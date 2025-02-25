package com.reno.mall.common.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.reno.mall.common.service.RedisService;
import com.reno.mall.common.service.impl.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * Redis 基础配置（重构版）
 * 优化点：
 * 1. 使用 @Configuration 明确配置类身份
 * 2. 通过 @EnableCaching 显式启用缓存
 * 3. 可配置的 TTL 时间
 * 4. 更健壮的序列化配置
 * 5. 使用 Builder 模式创建 CacheManager
 * 6. 增强 null 值处理
 */
@Configuration
@EnableCaching
public class BaseRedisConfig {

    // 从配置文件中注入缓存过期时间（默认1天）
    @Value("${spring.cache.redis.time-to-live:1d}")
    private Duration ttl;

    /**
     * 自定义 RedisTemplate 配置
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        // Key 的序列化方式
        StringRedisSerializer stringSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringSerializer);
        template.setHashKeySerializer(stringSerializer);

        // Value 的序列化方式
        Jackson2JsonRedisSerializer<Object> jsonSerializer = redisSerializer();
        template.setValueSerializer(jsonSerializer);
        template.setHashValueSerializer(jsonSerializer);

        // 启用事务支持（根据实际需要）
        template.setEnableTransactionSupport(true);

        template.afterPropertiesSet();
        return template;
    }

    /**
     * 自定义 JSON 序列化器
     */
    @Bean
    public Jackson2JsonRedisSerializer<Object> redisSerializer() {
        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);

        ObjectMapper objectMapper = new ObjectMapper();
        // 设置可见性
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 启用类型信息（用于反序列化多态类型）
        objectMapper.activateDefaultTyping(
                LaissezFaireSubTypeValidator.instance,
                ObjectMapper.DefaultTyping.EVERYTHING,
                JsonTypeInfo.As.PROPERTY
        );
        // 其他配置（按需添加）
        // objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        // objectMapper.registerModule(new JavaTimeModule());

        serializer.setObjectMapper(objectMapper);
        return serializer;
    }

    /**
     * 自定义 CacheManager 配置
     */
    @Bean
    public RedisCacheManager redisCacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(ttl) // 使用配置的 TTL
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer()))
                .disableCachingNullValues(); // 根据需求决定是否缓存 null

        return RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(config)
                .transactionAware() // 支持事务
                .build();
    }

    /**
     * Redis 服务封装
     */
    @Bean
    public RedisService redisService(RedisTemplate<String, Object> redisTemplate) {
        return new RedisServiceImpl(redisTemplate); // 通过构造器注入
    }
}
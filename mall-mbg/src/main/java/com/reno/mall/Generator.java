package com.reno.mall;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * MBG代码生成工具
 * Created by macro on 2018/4/26.
 */
public class Generator {

    private static final Logger logger = LoggerFactory.getLogger(Generator.class);

    public static void main(String[] args) {
        if (args.length == 0) {
            logger.error("请指定配置文件路径");
            return;
        }

        String configFilePath = args[0];
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        //try-with-resources
        try (InputStream is = Generator.class.getResourceAsStream(configFilePath)) {
            if (is == null) {
                logger.error("配置文件未找到: {}", configFilePath);
                return;
            }

            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(is);

            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);

            warnings.forEach(logger::warn);

        } catch (Exception e) {
            logger.error("生成代码时发生错误", e);
        }
    }
}
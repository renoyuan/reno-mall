MyBatis 核心解析
一、框架定位与核心价值
MyBatis 是一款半自动化的持久层框架，通过简化 JDBC 操作、提供灵活 SQL 映射和动态 SQL 支持，实现 Java 对象与关系型数据库的高效交互其核心价值在于：

- ​SQL 控制权保留：开发者可完全掌控 SQL 语句，支持复杂查询优化；
- ​轻量级设计：无第三方依赖，学习成本低，适合需要精细控制 SQL 的场景；
- ​解耦与灵活性：SQL 与 Java 代码分离，动态 SQL 支持条件分支、循环等复杂逻辑
  二、架构设计分层
  MyBatis 架构分为三层，协同完成数据库操作：
  1.​
  接口层（API 层）​​
  提供与数据库交互的入口（如 SqlSession），通过动态代理将 Mapper 接口与 XML/注解配置的 SQL 绑定
  1
  3
  javaUserMapper userMapper = sqlSession.getMapper(UserMapper.class);
  User user = userMapper.selectById(1);
  2.​核心处理层​
- ​SQL 解析：根据配置生成 MappedStatement，解析动态 SQL（如 <if>、<foreach> 标签）
  3
  12
- ​执行引擎：通过 Executor 执行 SQL，处理参数映射（Java → JDBC 类型）与结果集映射（JDBC → Java 对象）
  1
  4
- ​事务管理：支持本地事务与集成 Spring 等框架的分布式事务
  4
  11
  1.​
  基础支撑层​
- ​连接池：集成 Druid、HikariCP 等，管理数据库连接复用；
- ​缓存机制：一级缓存（Session 级别）与二级缓存（全局级别）减少数据库压力
  1
  8
- ​类型转换：处理 Java 类型与数据库类型的自动转换（如 LocalDateTime → TIMESTAMP）
  三、核心功能特性
  1.​
  动态 SQL​
  通过 XML 标签（如 <if>、<choose>）或注解动态拼接 SQL，适应多条件查询场景
  1
  12
  xml<select id="findUsers">
  SELECT * FROM users
  <where>
  <if test="name != null">AND name = #{name}</if>
  <if test="age != null">AND age > #{age}</if>
  </where>
  </select>
  2.​
  结果映射​
  支持自动或自定义映射规则，处理复杂关联（如一对多、嵌套结果集）：
  xml<resultMap id="userMap" type="User">
  <id property="id" column="user_id"/>
  <collection property="orders" ofType="Order" select="selectOrdersByUserId"/>
  </resultMap>
  3.​
  插件扩展​
  可自定义拦截器（如分页插件、SQL 性能监控），在 SQL 执行前后插入逻辑

四、典型应用场景
1.​​复杂 SQL 优化​
需要手动编写高性能 SQL 的金融、电商系统（如分库分表查询
2.​多数据库适配​
支持 MySQL、Oracle 等多种数据库，适用于需兼容不同数据库的跨平台项目
3.​高并发读写​
结合缓存机制（如 Redis + MyBatis 二级缓存）提升读性能
4.​遗留系统改造​
逐步替换 JDBC 代码，降低迁移风险

五、与 Hibernate 对比

​维度​​MyBatis​​Hibernate​​SQL 控制​完全手动编写，灵活性高自动生成，灵活性低​性能优化​适合复杂查询优化适合简单 CRUD，复杂查询需 HQL​学习曲线​低（仅需掌握 SQL 映射）高（需理解 HQL、缓存策略）​适用场景​需要精细控制 SQL 的中大型系统快速开发、对象关系复杂的 OLTP 系统

六、最佳实践建议
1.​SQL 管理​
- 使用 XML 集中管理复杂 SQL，注解适用于简单语句；
- 动态 SQL 优先使用 <where> 标签避免语法错误

2.​性能调优​
- 启用二级缓存时注意缓存失效策略；
- 批量操作使用 BATCH 执行器减少网络开销


3.​安全规范​
- 参数绑定使用 #{} 防止 SQL 注入，避免 ${} 拼接

总结
MyBatis 凭借其对 SQL 的灵活控制、轻量级设计和高效映射机制，成为企业级应用开发的核心工具。适用于需要深度优化数据库交互、兼顾性能与灵活性的场景掌握其分层架构与动态 SQL 能力，可显著提升系统可维护性与扩展性。


MyBatis Generator（MBG）核心解析
一、框架定位与核心功能
MyBatis Generator（MBG）是 MyBatis 官方提供的代码生成工具，通过解析数据库表结构，自动生成以下内容


1.​实体类（POJO）​：与表字段对应的 Java 类，包含基本字段的 Getter/Setter 方法。
2.​Mapper 接口：定义基础的 CRUD 操作方法（如 insert, selectByPrimaryKey）。
3.​XML 映射文件：实现 SQL 与 Java 方法的绑定，支持动态 SQL 拼接。
4.​Example 类​（可选）：用于构建复杂查询条件（如 UserExample 定义 andNameLike 方法）。
其核心价值在于减少重复编码，提升开发效率，尤其适用于多表、高复杂度的数据库操作场景


--------------------------------------------------------------------------------
二、核心使用步骤
1. ​依赖引入
   通过 Maven 或 Gradle 添加 MBG 依赖：
   xml<dependency>
   <groupId>org.mybatis.generator</groupId>
   <artifactId>mybatis-generator-core</artifactId>
   <version>1.4.0</version>
   </dependency>
   或使用 Maven 插件直接运行

xml<plugin>
<groupId>org.mybatis.generator</groupId>
<artifactId>mybatis-generator-maven-plugin</artifactId>
<version>1.4.0</version>
</plugin>
2. ​配置文件编写
   创建 generatorConfig.xml，核心配置项包括：
- ​数据库连接：指定 JDBC 驱动、URL、用户名和密码
- ​代码生成路径：
  xml<javaModelGenerator targetPackage="com.example.entity" targetProject="src/main/java"/>
  <sqlMapGenerator targetPackage="mapper" targetProject="src/main/resources"/>
  <javaClientGenerator type="XMLMAPPER" targetPackage="com.example.mapper"/>
- ​表映射规则：定义生成代码的表名、实体类名及字段映射

xml<table tableName="user" domainObjectName="User">
<columnOverride column="create_time" property="createTime" jdbcType="TIMESTAMP"/>
</table>
3. ​运行生成器
- ​命令行：执行 mvn mybatis-generator:generate
- ​Java 代码：通过 MyBatisGenerator 类动态加载配置

javaList<String> warnings = new ArrayList<>();
Configuration config = new ConfigurationParser(warnings).parseConfiguration(configFile);
new MyBatisGenerator(config, new DefaultShellCallback(true), warnings).generate(null);
--------------------------------------------------------------------------------
三、配置文件深度解析
1. ​**<context> 配置**
- targetRuntime：指定生成代码风格，如 MyBatis3（默认）或 MyBatis3Simple（简化 Example 类）

- defaultModelType：控制实体类生成模式，推荐 flat（单类包含所有字段）

2. ​动态 SQL 支持
   通过 <if>, <where> 等标签生成动态 SQL，例如分页查询条件


xml<sqlMapGenerator>
<property name="enableSubPackages" value="true"/>
</sqlMapGenerator>
3. ​Example 类控制
   若需禁用 Example 类，设置 enableXXXByExample="false"


xml<table tableName="user" enableSelectByExample="false" enableUpdateByExample="false"/>
--------------------------------------------------------------------------------
四、高级特性与扩展
1.​集成 tk.MyBatis​
结合 tk.mybatis.mapper 插件，生成通用 Mapper 接口，支持更多复杂操作

2.​自定义插件​
通过 <plugin> 标签扩展功能，例如：
- ​Lombok 支持：生成实体类时添加 @Data 注解
- ​日志增强：自动插入方法执行日志。

3. 多环境适配​
   使用 <properties> 引入外部配置文件，实现开发/生产环境配置分离
--------------------------------------------------------------------------------
五、注意事项
1.​覆盖策略​
配置 <overwrite>true</overwrite> 避免重复生成时文件冲突


2.​IDE 兼容性​
Eclipse 需安装 MBG 插件，IntelliJ IDEA 需启用 Enable Annotation Processing

3.​依赖路径问题​
<classPathEntry> 需正确指定数据库驱动 JAR 路径，否则无法连接数据库

--------------------------------------------------------------------------------
六、最佳实践建议
1.​模型选择​
优先使用 flat 模型简化实体类结构，避免多层继承带来的复杂度

2.​包结构规划​
按模块划分包路径（如 com.example.module.entity），提升代码可维护性

3.​结合其他工具​
搭配 PageHelper 实现分页，或集成 Druid 连接池优化性能

--------------------------------------------------------------------------------
总结
MyBatis Generator 通过自动化代码生成，显著减少数据库操作层的开发工作量。其核心优势在于灵活的配置能力和高度可扩展性，适合中大型项目快速迭代。合理使用 MBG 可提升代码规范性，但需注意生成规则与团队编码风格的一致性


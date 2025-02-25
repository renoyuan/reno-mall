# reno-mall
reno-mall
## 项目介绍
代码源自 https://github.com/macrozheng/mall

reno-mall 是一个电商项目，包括前台商城系统和后台管理系统，基于SpringBoot+MyBatis实现。前台商城系统包含首页门户、商品推荐、商品搜索、商品展示、购物车、订单流程、会员中心等模块。后台管理系统包含商品管理、订单管理、会员管理、促销管理、运营管理、内容管理、统计报表、财务管理等模块。

## 项目地址
https://github.com/renoyuan/reno-mall

相关项目：

前端项目mall-app-web地址：https://github.com/macrozheng/mall-app-web

前端项目mall-admin-web地址：https://github.com/macrozheng/mall-admin-web


项目部署
```aiignore
reno-mall
├── mall-common -- 工具类及通用代码
├── mall-mbg -- MyBatisGenerator生成的数据库操作代码
├── mall-security -- SpringSecurity封装公用模块
├── mall-admin -- 后台商城管理系统接口
├── mall-search -- 基于Elasticsearch的商品搜索系统
├── mall-portal -- 前台商城系统接口
└── mall-demo -- 框架搭建时的测试代码
```
技术选型
后端技术
技术	说明	官网
SpringBoot	Web应用开发框架	https://spring.io/projects/spring-boot
SpringSecurity	认证和授权框架	https://spring.io/projects/spring-security
MyBatis	ORM框架	http://www.mybatis.org/mybatis-3/zh/index.html
MyBatisGenerator	数据层代码生成器	http://www.mybatis.org/generator/index.html
Elasticsearch	搜索引擎	https://github.com/elastic/elasticsearch
RabbitMQ	消息队列	https://www.rabbitmq.com/
Redis	内存数据存储	https://redis.io/
MongoDB	NoSql数据库	https://www.mongodb.com
LogStash	日志收集工具	https://github.com/elastic/logstash
Kibana	日志可视化查看工具	https://github.com/elastic/kibana
Nginx	静态资源服务器	https://www.nginx.com/
Docker	应用容器引擎	https://www.docker.com
Jenkins	自动化部署工具	https://github.com/jenkinsci/jenkins
Druid	数据库连接池	https://github.com/alibaba/druid
OSS	对象存储	https://github.com/aliyun/aliyun-oss-java-sdk
MinIO	对象存储	https://github.com/minio/minio
JWT	JWT登录支持	https://github.com/jwtk/jjwt
Lombok	Java语言增强库	https://github.com/rzwitserloot/lombok
Hutool	Java工具类库	https://github.com/looly/hutool
PageHelper	MyBatis物理分页插件	http://git.oschina.net/free/Mybatis_PageHelper
Swagger-UI	API文档生成工具	https://github.com/swagger-api/swagger-ui
Hibernator-Validator	验证框架	http://hibernate.org/validator
前端技术
技术	说明	官网
Vue	前端框架	https://vuejs.org/
Vue-router	路由框架	https://router.vuejs.org/
Vuex	全局状态管理框架	https://vuex.vuejs.org/
Element	前端UI框架	https://element.eleme.io
Axios	前端HTTP框架	https://github.com/axios/axios
v-charts	基于Echarts的图表框架	https://v-charts.js.org/
Js-cookie	cookie管理工具	https://github.com/js-cookie/js-cookie
nprogress	进度条控件	https://github.com/rstacruz/nprogress
移动端技术
技术	说明	官网
Vue	核心前端框架	https://vuejs.org
Vuex	全局状态管理框架	https://vuex.vuejs.org
uni-app	移动端前端框架	https://uniapp.dcloud.io
mix-mall	电商项目模板	https://ext.dcloud.net.cn/plugin?id=200
luch-request	HTTP请求框架	https://github.com/lei-mu/luch-request


day 1 使用  MyBatisGenerator 生成数据库操作代码
day 2 开发接口
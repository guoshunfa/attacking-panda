# 进击的熊猫 java项目

## 启动项目

1. 如果没有初始化过数据库，需要执行sql目录下的sql文件，初始化过的跳过本环节。
2. 调整application.properties中的mysql数据库信息、redis数据库信息、log打印地址。
3. 直接执行com.panda.admin.PandaAdminApplication类的main方法。

## 项目使用

### 代码生成

前往com.panda.framework.generate.CodeGenerate类，调整上方常量属性值，执行main方法。

## 技术栈选取

- 基础框架：[Spring Boot](https://spring.io/projects/spring-boot)
- 持久层框架：[Mybatis](https://mybatis.org/mybatis-3/zh/index.html)
- Mybatis增强工具：[Mybatis Plus](https://baomidou.com/)
- 登陆鉴权：[Spring Security](https://spring.io/projects/spring-security) + JWT
- 主数据源：[Mysql](https://dev.mysql.com/doc/)
- 缓存数据源：[Redis](https://redis.io/docs/)
- 日志记录：[Logback](https://logback.qos.ch/documentation.html)
- 工具包：[Hutool](https://hutool.cn/docs/#/)
- 接口文档：[Swagger](https://pandacode.cn/pages/d34b3a/)

后续补充：

- 流程管理：[Activiti](https://spring.io/blog/2015/03/08/getting-started-with-activiti-and-spring-boot)
- 模版引擎：[FreeMarker](https://freemarker.apache.org/)

## 版本选取

- Mysql 5.6
- jdk 8

## 目录介绍

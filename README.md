## 一、代码配套书籍介绍
* 本书发布于：[http://springboot.zimug.com](http://springboot.zimug.com),会持续创作更新。
* 作者博客: [字母哥博客：www.zimug.com](http://www.zimug.com)

###  **这本电子书的价值？**
* 市面上售价70、80元一本的讲解spring boot的图书，因为出版章节及页数的限制，不可能讲解的全面细致，更多的是偏概念。而且技术是在不断发展的，很多内容都过时。
* 本书会随着作者的知识更新，不断更新。**笔者自认为，这本电子书是目前市面上spring boot知识梳理最系统、全面、合理的一本电子书**。

## 二、内容概览
* 第一章 spring boot 2.x基础及概念入门
    * 1.1.spring boot 产生的背景及其优势
    * 1.2.spring boot 2.x 新特性说明
    * 1.3.helloworld及项目结构介绍
    * 1.4.IDEA结合spring boot开发技巧
* 第二章 RESTFul接口实现与测试
    * 2.1.RESTFul接口与http协议状态表述
    * 2.2.常用注解开发一个RESTFul接口
    * 2.3 JSON数据处理与PostMan测试
    * 2.4.使用Mockito编码完成接口测试
    * 2.5. 使用Swagger2构建API文档
* 第三章 spring boot 配置原理实战
    * 3.1.结合配置加载讲解bean自动装配原理
    * 3.2.详解YAML语法及占位符语法
    * 3.3.获取自定义配置的两种实现方法
    * 3.4.配置文件注入值数据校验
    * 3.5.加载旧项目配置文件的两种方式
    * 3.6.profile不同环境使用不同配置
    * 3.7.配置及配置文件的加载优先级
    * 3.8.配置文件敏感字段加密
* 第四章 常用web开发数据库框架
    * 4.1.整合Spring JDBC操作数据
    * 4.2 Spring JDBC多数据源的实现
    * 4.3.Spring JDBC JTA实现分布式事务
    * 4.4.ORM主流框架选型
    * 4.5.bean转换Dozer的快速上手
    * 4.6.整合Spring Data JPA操作数据
    * 4.7.Spring data JPA的多数据源实现
    * 4.8.JPA+atomikos实现分布式事务
    * 4.9.整合Mybatis操作数据
    * 4.10.Mybatis开发最佳实践总结
    * 4.11.Spring mybatis的多数据源实现
    * 4.12.mybatis+atomikos实现分布式事务
    * 4.13.Spring事务与分布式事务
    * 4.14.整合Spring data mongodb操作数据
    * 4.15.一行代码实现RESTFul接口
* 第五章 静态资源与模板引擎的整合
    * 5.1.webjars与静态资源
    * 5.2.模板引擎选型与未来趋势
    * 5.3.web应用开发之整合jsp
    * 5.4.web应用开发之整合freemarker
    * 5.5.web应用开发之整合thymeleaf
    * 5.6.thymeleaf基础语法讲解
    * 5.7.thymeleaf内置对象与工具类
    * 5.8.公共片段(标签)与内联js
* 第六章 生命周期内的拦截过滤与监听
    * 6.1.servlet与filter与listener的实现
    * 6.2.spring拦截器及请求链路说明
    * 6.3.自定义事件的发布与监听
    * 6.4.应用启动的监听
* 第七章 嵌入式容器的配置与应用
    * 7.1.嵌入式的容器配置与调整
    * 7.2.切换到jetty&undertow容器
    * 7.3.打war包部署到外置tomcat容器
* 第八章 统一全局异常处理
    * 8.1.设计一个优秀的异常处理机制
    * 8.2.自定义异常和相关数据结构
    * 8.3.全局异常处理ExceptionHandler
    * 8.4.服务端数据校验与全局异常处理
    * 8.5.AOP实现完美异常处理方案
* 第九章 日志框架与全局日志管理
    * 9.1.日志框架的简介与选型
    * 9.2.logback日志框架整合使用
    * 9.3.log4j2日志框架整合与使用
    * 9.4.拦截器实现统一访问日志
* 第十章 异步任务与定时任务
    * 10.1.实现Async异步任务
    * 10.2.为异步任务规划线程池
    * 10.3.通过@Scheduled实现定时任务
    * 10.4.quartz简单定时任务(内存持久化)
    * 10.5.quartz动态定时任务(数据库持久化)
* 第十一章 redis缓存与session共享
    * 11.1.使用docker安装redis
    * 11.2.redis数据结构与应用场景
    * 11.3.使用redisTemplate操作数据
    * 11.4.使用Redis Repository操作数据
    * 11.5.spring cache基本用法
    * 11.6.详述缓存声明式注解的使用
    * 11.7.个性化自定义缓存到期时间
    * 11.8.集群多节点应用session共享
* 第十二章 整合分布式文件系统fastdfs
    * 12.1.fastdfs简介及架构说明
    * 12.2.使用docker安装fastdfs
    * 12.3.开发一个自定义fastdfs-starter
    * 12.4.整合fastdfs操作文件数据
* 第十三章 服务器推送技术
    * 13.1.主流服务器推送技术说明
    * 13.2.服务端推送事件SSE
    * 13.3.双向实时通信websocket
* 第十四章 消息队列的整合与使用
    * 14.1.消息队列与JMS规范简介
    * 14.2.使用docker安装activeMQ
    * 14.3.activeMQ实现点对点队列
    * 14.4.activeMQ实现发布订阅队列
    * 14.5.docker安装RocketMQ
    * 14.6.RocketMQ实现2种消费模式
    * 14.7.RocketMQ实现分布式事务
* 第十五章 邮件发送的整合与使用
    * 15.1.基础协议及邮件配置整合
    * 15.2.发送html和基于模板的邮件
    * 15.3.发送带附件和内联附件邮件
* 第十六章 响应式框架webflux
    * 16.1.webflux快速入门
    * 16.2.注解方式实现restful接口
    * 16.3.webflux整合mongodb
    * 16.4.webclient单元测试的编写
* 番外篇：周边技术生态
    * 如何使用git查看本教程代码
    * centos7安装docker图文详解
    * docker安装mongodb(单点)图文详解
    * 如何使用mybatis自动生成的代码



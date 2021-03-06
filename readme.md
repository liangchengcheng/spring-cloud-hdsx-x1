[toc]

# 前言

基于微服务的思想，构建在 B2C 电商场景下的项目实战。

* 整体的功能:(用户系统)（订单服务 --> 商品服务）（基础微服务：多媒体+redis缓存）

* 整体的功能如下图：![功能图](https://github.com/liangchengcheng/spring-cloud-hdsx-x1/blob/master/image/%E5%BD%AD%E6%AF%85%E7%89%88%E6%9C%AC%E6%B0%B4%E6%BA%90%E5%9C%B0%E8%84%9A%E6%89%8B%E6%9E%B6.png)

# 技术


## 项目结构

| 模块 | 名称 | 端口 | |
| --- | --- | --- | --- |
| `common` | 基础代码包 | HTTP 无 | |
| `user-service` | 用户 HTTP 服务 | HTTP （见配置） | |
| `product-service` | 商品 HTTP 服务 | HTTP （见配置） | |
| `order-service` | 订单 HTTP 服务 | HTTP （见配置） | |
| `eureka-service` | 订单 HTTP 服务 | HTTP （40000） | |
| `getway-service` | 订单 HTTP 服务 | HTTP （40010） | |
| `redis-service` | 缓存 HTTP 服务 | HTTP （见配置） | |
| `media-service` | 图片 HTTP 服务 | HTTP （见配置） | |

-------

后端项目，目前的项目结构如下：

```Java
[-] xxx
  ├──[-] web-service-xxx-api // 提供 FEGIN 服务 API 。
  ├──[-] web-service-xxx-server // 提供 服务 Service 实现 + controller对外。
```

考虑到大多数公司，无需拆分的特别细，并且过多 JVM 带来的服务器成本。所以目前的设定是：
* `web-service-xxx-server` 内嵌了 `controller ` 中运行。
也就是说，一个 `xxx-server` 启动后，该微服务就完整启动了，getway是对所有微服务的一个聚合，统一对外。

## 技术栈

### 后端

| 框架 | 说明 |  版本 |
| --- | --- | --- |
| [Spring Boot](https://spring.io/projects/spring-boot) | 应用开发框架 |   2.2.* |
| [Spring Cloud](https://spring.io/projects/spring-cloud) | 应用开发框架 |   F版 |
| [MySQL](https://www.mysql.com/cn/) | 数据库服务器 | 5.6 |
| [Druid](https://github.com/alibaba/druid) | JDBC 连接池、监控组件 | 1.1.16 |
| [MyBatis](http://www.mybatis.org/mybatis-3/zh/index.html) | 数据持久层框架 | 3.5.1 |
| [Redis](https://redis.io/) | key-value 数据库 | 暂未引入，等压测后，部分模块 |
| [Seata](https://github.com/seata/seata) | 分布式事务中间件 | 0.5.1 |
| [springfox-swagger2](https://github.com/springfox/springfox/tree/master/springfox-swagger2) | API 文档 | 2.9.2 |
| [swagger-bootstrap-ui](https://gitee.com/xiaoym/swagger-bootstrap-ui) | Swagger 增强 UI 实现 | 1.9.3 |


### 监控

一般来说，监控会有三种方式：

* 1、Tracing ，我们采用 Apache SkyWalking
* 2、Logging ，我们采用 ELK
* 3、Metrics ，我们采用 Prometheus

| 框架 | 说明 |  版本 |
| --- | --- | --- |
| [SkyWalking](http://skywalking.apache.org/) | 分布式应用追踪系统 | 6.0.0 |
| [Prometheus](https://prometheus.io/) | 服务监控体系 | 2.9.2 |
| [Alertmanager](https://prometheus.io/docs/alerting/alertmanager/) | 告警管理器 | 0.17.0 |
| [Grafana](https://grafana.com/) | 仪表盘和图形编辑器 | 0.17.0 |

### 其它

* Jenkins 持续集成
* Nginx 服务器
* [ ] Docker 容器
* [ ] Nginx

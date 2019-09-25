## 当前版本
V0.0.1
## jud cloud 

## 当前架构
- 基于Spring Boot 2.0.7.RELEASE
- 基于Spring Cloud Finchley.SR2
- 网关 Spring Cloud Gateway
- 注册中心 Eureka
- 认证方式 Spring Security oAuth2
- 持久层采用mybatis-plus 3.0.6
## 项目结构
- jud-cloud (项目根目录)
    - doc (文档目录)
    - jud-cloud-common (公共组件包)
        - jud-cloud-common-core (核心工具包)
        - jud-cloud-commom-data (数据操作包)
        - jud-cloud-common-gateway (网关工具包)
        - jud-cloud-common-log (日志工具包)
        - jud-cloud-common-minio (文件系统工具包)
        - jud-cloud-common-security (安全认证工具包)
        - jud-cloud-common-swagger (API文档工具包)
        - jud-cloud-common-transaction (分布式事务工具包)
    - jud-cloud-framework (框架)
        - jud-cloud-auth (认证中心)
        - jud-cloud-config (配置中心)
        - jud-cloud-eureka (注册中心)
        - jud-cloud-gateway (网关)
        - jud-cloud-upms (用户管理中心)
    - pom.xml (全局maven配置)
## 启动顺序
    1.jud-cloud-eureka (注册中心)
    2.jud-cloud-config (配置中心)
    3.jud-cloud-gateway (网关)
    4.jud-cloud-auth (认证中心)
    5.jud-cloud-upms (用户管理中心)

### 系统结构
``` lua
thatmall
├── framework -- 工具类及通用代码模块
    ├── framework-db -- mybatisplus配置封装
    ├── framework-es -- es配置封装
    ├── framework-log -- 日志配置封装
    ├── framework-redis -- redis工具类封装
    ├── framework-result -- 通用返回值工具类封装
    ├── framework-rocketmq -- 通用mq工具类封装
    ├── framework-service -- dubbo封装
    ├── framework-swagger -- swagger封装
    ├── framework-utils -- 常用工具类封装
    ├── framework-web -- web端通用封装
    ├── framework-manager -- 管理端端通用封装
├── goodscenter -- 商品中心
    ├── goodscenter-repository -- 商品中心数据仓库
    ├── goodscenter-api -- 商品中心对外接口
    ├── goodscenter-web -- 商品中心c端服务
    ├── goodscenter-service -- 商品中心c端服务
    ├── goodscenter-interface -- 商品中心管理端服务
    ├── goodscenter-manager -- 商品中心管理端服务
    ├── goodscenter-manager-service -- 商品中心管理端服务
├── inventorycenter -- 库存中心
├── pricecenter -- 价格中心
├── suppliercenter -- 供应商
├── marketcenter -- 营销中心
├── cmscenter -- 内容管理服务
├── searchcenter -- 搜索中心
├── tradecenter -- 交易中心
├── paycenter -- 支付中心
├── walletcenter -- 钱包
├── protocolcenter -- 履约中心
├── settlementcenter -- 结算中心
├── aftersalecenter -- 售后中心
├── commentcenter -- 评价中心
├── commentcenter -- 评价中心
├── commissioncenter -- 返利中心
├── usercenter -- 用户中心
├── addresscenter -- 地址库
├── messagecenter -- 地址库
├── IMcenter -- 实时通讯
├── osscenter -- 对象存储
├── mangercenter -- 后台用户权限管理
└── helpcenter -- 帮助中心
```
### 后端技术

| 技术                   | 说明                     |
| ---------------------- | ---------------------- |
| Spring Cloud           | 微服务框架               |
| Spring Cloud Alibaba   | 微服务框架               |
| Spring Boot            | 容器+MVC框架             |
| Dubbo                  | rpc                        |
| Nacos                  | 服务注册中心 配置中心
| MyBatisPlus            | ORM框架                 |
| Knife4j                | 文档工具                 | 
| Elasticsearch          | 搜索引擎                 |
| RocketMq               | 消息队列                 |
| Redis                  | 分布式缓存                |
| MongoDB                | NoSql数据库              | 
| Druid                  | 数据库连接池              | 
| JWT                    | JWT登录支持              |
| Lombok                 | 简化对象封装工具           | 
| Mapstruct              | 对象转换
| XxlJob                 | 分布式定时Job
| MySQL                  | 数据库
| fastJson               | Json对象
| Log4j2                 | 日志框架
| Nginx                  |
| Java8                  |
| ShardingJdbc           | 分库分表 读写分离
### 前端技术

| 技术       | 说明              |
| ---------- | --------------|
| Vue3.0        | 前端框架          |

![image](https://user-images.githubusercontent.com/6743244/156978528-9125f7d0-025e-4b51-99a1-6098f07d4efc.png)



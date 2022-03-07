
***************************
APPLICATION FAILED TO START
***************************
### Description:

> Parameter 0 of method modifyRequestBodyGatewayFilterFactory in org.springframework.cloud.gateway.config.GatewayAutoConfiguration required a bean of type 'org.springframework.http.codec.ServerCodecConfigurer' that could not be found.

### Action:

> Consider defining a bean of type 'org.springframework.http.codec.ServerCodecConfigurer' in your configuration.

出现该错误是因为Spring Cloud Gateway依赖了spring-boot-starter-web包
如果引入oauth2包
必须增加如下引入
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-oauth2-client</artifactId>
        </dependency>


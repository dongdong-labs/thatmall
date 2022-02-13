package org.onedayday.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: report
 * @class: GatewayApplication
 * @description:
 * @author: wdd
 * @create: 2020-09-24 23:27
 */
@SpringBootApplication(scanBasePackages = "org.onedayday")
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}

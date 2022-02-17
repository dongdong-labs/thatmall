package org.onedayday.authoritycenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @program: thatmall
 * @class: AuthoritycenterApplication
 * @description:
 * @author: wdd
 * @create: 2022-02-16 11:09
 */
@SpringBootApplication(scanBasePackages = {"org.onedayday"})
public class AuthoritycenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthoritycenterApplication.class, args);
    }
}

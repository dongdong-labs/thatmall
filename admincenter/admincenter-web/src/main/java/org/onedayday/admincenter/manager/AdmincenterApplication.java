package org.onedayday.admincenter.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: thatmall
 * @class: AdmincenterApplication
 * @description:
 * @author: wdd
 * @create: 2022-02-14 16:54
 */
@SpringBootApplication(scanBasePackages = "org.onedayday")
@MapperScan("org.onedayday.*.repository.mapper")
public class AdmincenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdmincenterApplication.class,args);
    }
}

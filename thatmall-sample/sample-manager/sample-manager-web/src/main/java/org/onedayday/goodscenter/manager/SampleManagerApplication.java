package org.onedayday.goodscenter.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: thatmall-sample
 * @class: SampleManagerApplication
 * @description:
 * @author: wdd
 * @create: 2022-02-09 15:37
 */
@SpringBootApplication(scanBasePackages = {"org.onedayday"})
@MapperScan("org.onedayday.*.repository.mapper")
public class SampleManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SampleManagerApplication.class, args);
    }
}

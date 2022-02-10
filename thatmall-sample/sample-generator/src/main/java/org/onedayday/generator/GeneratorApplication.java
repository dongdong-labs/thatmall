package org.onedayday.generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: report
 * @class: Generator
 * @description: 代码生成器
 * @author: wdd
 * @create: 2020-05-26 23:02
 */
@SpringBootApplication(scanBasePackages = {"org.onedayday"})
public class GeneratorApplication {
    public static void main(String[] args) {
        SpringApplication.run(GeneratorApplication.class, args);
    }
}

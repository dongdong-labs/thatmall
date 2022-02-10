package org.onedayday;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.onedayday.generator.GeneratorApplication;
import org.onedayday.generator.service.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @class: generator
 * @description:
 */
@SpringBootTest(classes = GeneratorApplication.class)
@RunWith(SpringRunner.class)
public class GeneratorTest {
    @Autowired
    private GeneratorService generatorService;

    String dbName = "user_center";
    String moduleName = "goodscenter";
    String[] tableNames = new String[]{"dept"};

    @Test
    public void generator(){
        generatorService.generator(dbName,moduleName,tableNames);
    }
}

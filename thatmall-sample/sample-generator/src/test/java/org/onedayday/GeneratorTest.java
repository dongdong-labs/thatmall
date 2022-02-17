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

    String dbName = "tm_admincenter";
    String moduleName = "admincenter";
    String[] tableNames = new String[]{"t_user_role_rel","t_menu","t_permission","t_resource","t_role","t_role_menu_rel","t_role_permission_rel","t_user","t_user_permission_rel","t_user_role_rel"};

    @Test
    public void generator(){
        generatorService.generator(dbName,moduleName,tableNames);
    }
}

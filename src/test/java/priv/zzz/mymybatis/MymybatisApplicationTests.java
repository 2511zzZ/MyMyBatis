package priv.zzz.mymybatis;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import priv.zzz.app.Appconfig;
import priv.zzz.app.MyInvokationHandler;
import priv.zzz.dao.AnchorDao;
import priv.zzz.dao.UserDao;
import priv.zzz.service.UserService;

import java.lang.reflect.Proxy;

@SpringBootTest
class MymybatisApplicationTests {

    @Test
    void contextLoads() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);
        ac.getBean(AnchorDao.class).query();
        ac.getBean(UserDao.class).query();

    }

}

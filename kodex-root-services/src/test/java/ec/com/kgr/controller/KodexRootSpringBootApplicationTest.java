package ec.com.kgr.controller;

import ec.com.kgr.KodexRootSpringBootApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * KodexRootSpringBootApplicationTest.
 *
 * @author components on 21/9/2022.
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("CONSOLA")
@SpringBootTest
public class KodexRootSpringBootApplicationTest {


    @Test
    @Order(1)
    public void contextLoads() {
    }

    @Test
    @Order(2)
    public void testApplicationError() {
        //new String[]{}
        KodexRootSpringBootApplication.main(null);
        Assert.assertTrue(true);

    }


}

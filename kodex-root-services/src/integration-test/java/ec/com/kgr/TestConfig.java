package ec.com.kgr;

import java.util.Properties;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfig {

    @Bean
    BuildProperties buildProperties() {
        return new BuildProperties(new Properties());
    }

}


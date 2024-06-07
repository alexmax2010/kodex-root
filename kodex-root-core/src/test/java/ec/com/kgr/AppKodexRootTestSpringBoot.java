package ec.com.kgr;

import java.util.Objects;
import ec.com.kgr.config.KodexRootConfiguration;
import ec.com.kruger.spring.boot.test.SecurityUserInfoTestConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Slf4j
@Import({KodexRootConfiguration.class, SecurityUserInfoTestConfiguration.class})
@SpringBootApplication(scanBasePackages = {"ec.com.kgr"})
public class AppKodexRootTestSpringBoot {

    /**
     * Main run spring boot app.
     *
     * @param args an array of {@link String} objects.
     */
    public static void main(String... args) {

        try {
            SpringApplication app = new SpringApplication(AppKodexRootTestSpringBoot.class);
            app.run(args);

        } catch (Exception throwable) {
            if (!Objects.equals(throwable.getClass().getName(),
                "org.springframework.boot.devtools.restart.SilentExitExceptionHandler$SilentExitException")
                && log.isErrorEnabled()) {
                log.error(
                    "*************************************Ha ocurrido una exception**********************************");
                log.error("Exception: " + throwable.toString());
                log.error("Root Cause: " + ExceptionUtils.getRootCause(throwable).toString());
            }
        }

    }
}

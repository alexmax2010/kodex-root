package ec.com.kgr;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import ec.com.kgr.config.KodexRootConfiguration;
import ec.com.kruger.security.sso.springboot2.configuration.simple.SimpleSecurityKeycloakConfiguration;
import ec.com.kruger.spring.metric.config.DefaultApplicationContextMetricConfig;
import ec.com.kruger.spring.ws.config.WebConfig;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.ObjectSchema;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Main class to run spring boot app.
 *
 * @author components on 2/21/19.
 * @version 1.0
 * @since 1.0.0
 */
@SpringBootApplication(scanBasePackages = "ec.com.kgr")
@Import({KodexRootConfiguration.class,
    DefaultApplicationContextMetricConfig.class,
    WebConfig.class,
    SimpleSecurityKeycloakConfiguration.class})
@Slf4j
public class KodexRootSpringBootApplication extends SpringBootServletInitializer implements
    WebMvcConfigurer {

    @Autowired
    private BuildProperties buildProperties;

    /**
     * Main to run app.
     *
     * @param args args to pass app
     */
    public static void main(String... args) {
        try {
            SpringApplication app = new SpringApplication(KodexRootSpringBootApplication.class);
            app.run(args);
        } catch (Exception throwable) {
            if (!Objects.equals(throwable.getClass().getName(),
                "org.springframework.boot.devtools.restart.SilentExitExceptionHandler$SilentExitException")
                && log.isErrorEnabled()) {
                log.error(
                    "********************************Ha ocurrido una exception****************************");
                log.error("Exception: " + throwable.toString());
                log.error("Root Cause: " + ExceptionUtils.getRootCause(throwable).toString());
            }
        }
    }

    /**
     * commandLineRunner.
     *
     * @param ctx the ctx
     * @return CommandLineRunner instance
     */
    @Bean
    public CommandLineRunner commandLineRunner(ListableBeanFactory ctx) {
        if (log.isDebugEnabled()) {
            log.debug("Beans Loaded by Spring Boot:{}", ctx.getBeanDefinitionCount());
        }
        return args -> {
            if (log.isDebugEnabled()) {
                String[] beanNames = ctx.getBeanDefinitionNames();
                Arrays.sort(beanNames);
                for (String beanName : beanNames) {
                    log.debug("Bean:{}", beanName);
                }
            }
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*")
            .allowedMethods("GET", "POST", "PUT", "DELETE");
    }

    /**
     * Open api bean definition.
     *
     * @return OpenAPI
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .security(Arrays.asList(new SecurityRequirement().addList("bearerAuth")))
            .components(new Components().addSecuritySchemes("bearerAuth",
                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer")
                    .bearerFormat("JWT")))
            .info(new Info().title("REST API Documentation")
                .description("REST API Documentation for services")
                .version(buildProperties.getVersion())
                .contact(new Contact()
                    .name("Kruger Corp")
                    .email("admin@ec.krugercorporation.com")
                    .url("https://www.krugercorp.com"))
                .license(new License()
                    .name("Apache 2.0")
                    .url("http://www.apache.org/licenses/LICENSE-2.0.html")));
    }

    /**
     * Grouped Bean to all APIs with `/v1/` in the path.
     *
     * @return GroupedOpenApi
     */
    @Bean
    public GroupedOpenApi v1Apis() {
        return GroupedOpenApi.builder().group("V1 API").pathsToMatch("/**/v1/**").build();
    }

    /**
     * Grouped Bean to all APIs with `/v2/` in the path.
     *
     * @return GroupedOpenApi
     */
    @Bean
    public GroupedOpenApi v2Apis() {
        return GroupedOpenApi.builder().group("V2 API").pathsToMatch("/**/v2/**").build();
    }


    /**
     * Grouped bean to all APIs with `/v1/inet/` in the path.
     *
     * @return GroupedOpenApi
     */
    @Bean
    public GroupedOpenApi inetApis() {
        return GroupedOpenApi.builder().group("Internet API").pathsToMatch("/**/v1/inet/**")
            .build();
    }

    /**
     * Open api customiser.
     *
     * @return OpenApiCustomiser
     */
    @Bean
    public OpenApiCustomiser openApiCustomiser() {
        return openApi -> {
            ObjectSchema mySchema = new ObjectSchema();
            mySchema.name("MySchema");
            Map<String, Schema> schemas = openApi.getComponents().getSchemas();
            schemas.put(mySchema.getName(), mySchema);
        };
    }

}

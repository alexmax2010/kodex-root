package ec.com.kgr.config;

import javax.persistence.EntityManagerFactory;
import ec.com.kruger.spring.orm.jpa.config.simple.SimpleSecurityAuditListenerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * KodexRoot spring configuration.
 *
 * @author components on 2021/08/02.
 * @version 1.0
 */
@EntityScan(basePackages = "ec.com.kgr.entity")
@EnableJpaRepositories(basePackages = "ec.com.kgr.repository")
@ComponentScan(basePackages = "ec.com.kgr")
@EnableTransactionManagement
@Import(SimpleSecurityAuditListenerConfig.class)
public class KodexRootConfiguration {

    /**
     * <p>
     * transactionManager.
     * </p>
     *
     * @param emf a {@link javax.persistence.EntityManagerFactory} object.
     * @return a {@link org.springframework.transaction.PlatformTransactionManager} object.
     */
    @Bean
    @Autowired
    public PlatformTransactionManager jpaTransactionManager(EntityManagerFactory emf) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(emf);
        return txManager;
    }

}

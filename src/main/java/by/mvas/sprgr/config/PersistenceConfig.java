package by.mvas.sprgr.config;

import com.googlecode.flyway.core.Flyway;
import java.util.Properties;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author mvas
 */
@Configuration
//@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "by.mvas.sprgr.repository")
public class PersistenceConfig {

    @Value("${database.driver}")
    private String dbDriverName;

    @Value("${database.url}")
    private String dbUrl;

    @Value("${database.login}")
    private String dbLogin;

    @Value("${database.password}")
    private String dbPassword;

    @Value("${hibernate.hbm2ddl.auto}")
    private String hibernatehbm2ddl;

    @Value("${hibernate.dialect}")
    private String hibernateDialect;

    @Bean(destroyMethod = "close")
    public BasicDataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(dbDriverName);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbLogin);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }

    @Bean(initMethod = "migrate")
    public Flyway flyway() {
        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource());
        flyway.setInitOnMigrate(true);
        flyway.setInitVersion("0");
        flyway.setInitDescription("Base migration");
        flyway.setLocations(new String[]{"classpath:db/migration/"});
        return flyway;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan("by.mvas.sprgr.model");
        entityManagerFactoryBean.setJpaProperties(hibernateProperties());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
        return entityManagerFactoryBean;
    }

    Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", hibernatehbm2ddl);
        properties.setProperty("hibernate.dialect", hibernateDialect);
        return properties;
    }

    @Bean
    @Autowired
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}

package by.mvas.sprgr.config;

import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 * Main config
 *
 * @author Max
 */
@Configuration
@ComponentScan(basePackages = "by.mvas.sprgr")
@Import({PropertyConfig.class, I18nConfig.class})
public class AppConfig {

    @Value("${property}")
    private String property;

    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public UserSession userSession() {
        return new UserSession(new Date());
    }

    @Bean
    public PropertyContainer propertyContainer() {
        return new PropertyContainer(property);
    }

}

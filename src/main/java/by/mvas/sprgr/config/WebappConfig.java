package by.mvas.sprgr.config;

import by.mvas.sprgr.model.Quote;
import by.mvas.sprgr.model.QuoteTag;
import by.mvas.sprgr.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

/**
 * @author Max
 */
@Configuration
@EnableWebMvc
public class WebappConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private Formatter<Role> roleFormatter;

    @Autowired
    private Converter<String, Quote> quoteConverter;

    @Autowired
    private Converter<String, QuoteTag> quoteTagConverter;

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer configurer = new TilesConfigurer();
        configurer.setDefinitions(new String[]{"/WEB-INF/tiles/tiles-definitions.xml"});
        return configurer;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(roleFormatter);
        registry.addConverter(quoteConverter);
        registry.addConverter(quoteTagConverter);
    }

}

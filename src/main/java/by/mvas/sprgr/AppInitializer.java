package by.mvas.sprgr;

import by.mvas.sprgr.Filter.UTF8ResponseFilter;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.Log4jConfigListener;

/**
 * Instead of web.xml
 *
 * @author Max
 */
public class AppInitializer implements WebApplicationInitializer {

    private static final String CONFIG_PACKAGE = "by.mvas.sprgr.config";
    private static final String LOG4J_CONFIG_LOCATION = "/WEB-INF/resources/log4j.properties";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        // encoding filter
        servletContext.addFilter("utf8filter", UTF8ResponseFilter.class).addMappingForUrlPatterns(null, false, "/*");

        // log4j config
        servletContext.addListener(Log4jConfigListener.class);
        servletContext.setInitParameter("log4jConfigLocation", LOG4J_CONFIG_LOCATION);

        // servlet config
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation(CONFIG_PACKAGE); // webapp context, wired with config packages
        servletContext.addListener(new ContextLoaderListener(context)); // context loader listener
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("main", new DispatcherServlet(context)); // servlet adding and config
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }

}

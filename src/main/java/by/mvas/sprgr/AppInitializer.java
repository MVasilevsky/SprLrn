package by.mvas.sprgr;

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

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        
        // log4j config
        servletContext.addListener(Log4jConfigListener.class);
        servletContext.setInitParameter("log4jConfigLocation", "/WEB-INF/resources/log4j.properties");
        
        // servlet config
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("by.mvas.sprgr.config"); // webapp context, wired with config packages
        servletContext.addListener(new ContextLoaderListener(context)); // context loader listener
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("main", new DispatcherServlet(context)); // servlet adding and config
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
    
}

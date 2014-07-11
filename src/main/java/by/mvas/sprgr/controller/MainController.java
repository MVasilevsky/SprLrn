package by.mvas.sprgr.controller;

import by.mvas.sprgr.config.PropertyContainer;
import by.mvas.sprgr.config.UserSession;
import by.mvas.sprgr.preprocessing.SLLog;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Max
 */
@RestController
public class MainController {

    @SLLog
    private Logger logger;

    @Autowired
    private UserSession session;

    @Autowired
    private PropertyContainer container;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/")
    public String main(HttpServletRequest request) {
        return "Hello, Spring MVC! <br> Session demo: " + session.getDate().toString()
                + "<br> Property demo: " + container.getProperty()
                + "<br> Message demo: " + messageSource.getMessage("mess", null, request.getLocale());
    }
    
}

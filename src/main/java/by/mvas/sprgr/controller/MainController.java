package by.mvas.sprgr.controller;

import by.mvas.sprgr.config.UserSession;
import by.mvas.sprgr.preprocessing.SLLog;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/")
    public String main() {
        logger.info("request received");
        return "Hello, Spring MVC! " + session.getDate().toString();
    }

}

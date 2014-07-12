package by.mvas.sprgr.controller;

import by.mvas.sprgr.preprocessing.SLLog;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Max
 */
@Controller
public class MainController {

    @SLLog
    private Logger logger;

    @RequestMapping("/")
    public String main() {
        return "main";
    }

}

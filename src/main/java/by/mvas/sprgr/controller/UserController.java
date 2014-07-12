package by.mvas.sprgr.controller;

import by.mvas.sprgr.model.Role;
import by.mvas.sprgr.model.User;
import by.mvas.sprgr.preprocessing.SLLog;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author mvas
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @SLLog
    private Logger logger;

//    @Secured
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ModelAndView userAdd() {

        return new ModelAndView("useradd"/*, "roles", new String[] {"admin", "user", "read-only"}*/);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String userAddDo(User user) {
        logger.info("User added: " + user.getLogin() + " (" + user.getRole().getCode() + ")");
        return "useradd";
    }

}

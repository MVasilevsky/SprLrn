package by.mvas.sprgr.controller;

import by.mvas.sprgr.model.Role;
import by.mvas.sprgr.model.User;
import by.mvas.sprgr.preprocessing.SLLog;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    private static List<User> users = new ArrayList<>();

    @RequestMapping("")
    public ModelAndView list() {
        return new ModelAndView("userlist", "users", users);
    }

//    @Secured
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ModelAndView add() {
        return new ModelAndView("useradd"/*, "roles", new String[] {"admin", "user", "read-only"}*/);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addDo(User user) {
        user.setRegistrationDate(new Date());
        users.add(user);
        logger.info("User added: " + user.getLogin() + " (" + user.getRole().getCode() + ")");
        return "redirect:/user";
    }

}

package by.mvas.sprgr.controller;

import by.mvas.sprgr.model.QuoteTag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author mvas
 */
@Controller
@RequestMapping("/tag")
public class QuoteTagController {
    
    @RequestMapping("")
    public ModelAndView list() {
        return new ModelAndView(""); // TODO
    }
    
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add() {
        return "tag.add";
    }
    
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addDo(QuoteTag tag) {
        // ...
        return "tag.add";
    }
    
}

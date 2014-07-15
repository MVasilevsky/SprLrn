package by.mvas.sprgr.controller;

import by.mvas.sprgr.model.QuoteTag;
import by.mvas.sprgr.preprocessing.SLLog;
import by.mvas.sprgr.repository.QuoteTagRepository;
import java.util.Date;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author mvas
 */
@Controller
@RequestMapping("tag")
public class TagController {

    @SLLog
    private Logger logger;

    @Autowired
    private QuoteTagRepository tagRepository;

    @RequestMapping("")
    public ModelAndView list() {
        return new ModelAndView("taglist", "tags", tagRepository.findAll());
    }

//    @Secured
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add() {
        return "tagadd";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addDo(QuoteTag tag) {
        tag.setCreationDate(new Date());
        tagRepository.save(tag);
        logger.info("Tag added: " + tag.getTitle());
        return "redirect:/tag";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id) {
        tagRepository.delete(id);
        return "redirect:/tag";
    }

}

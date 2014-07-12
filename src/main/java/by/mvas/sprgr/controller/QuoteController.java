package by.mvas.sprgr.controller;

import by.mvas.sprgr.model.Quote;
import by.mvas.sprgr.model.QuoteTag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author mvas
 */
@Controller
@RequestMapping("/quote")
public class QuoteController {

    @Autowired
    private ConversionService conversionService;

    @RequestMapping("")
    public ModelAndView list() {
        // ....
        return new ModelAndView("");
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add() {
        return "quote.add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addDo(Quote quote, List<String> quoteTags) {
        List<QuoteTag> quoteTags1 = (List<QuoteTag>) conversionService.convert(quoteTags,
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(String.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(QuoteTag.class)));

        quote.setTags(quoteTags1);

        return "quote.add";
    }

}

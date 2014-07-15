package by.mvas.sprgr.controller;

import by.mvas.sprgr.model.Quote;
import by.mvas.sprgr.model.QuoteTag;
import by.mvas.sprgr.repository.QuoteRepository;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @Autowired
    private QuoteRepository quoteRepository;

    @RequestMapping("")
    public ModelAndView list() {
        return new ModelAndView("quotelist", "quotes", quoteRepository.findAll());
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add() {
        return "quoteadd";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addDo(List<String> quoteTags, byte[] image) {
        Quote quote = new Quote();
        List<QuoteTag> quoteTags1 = (List<QuoteTag>) conversionService.convert(quoteTags,
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(String.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(QuoteTag.class)));
        quote.setTags(quoteTags1);
        quote.setPicture(image);
        quote.setUploadingDate(new Date());
        // quote.setUploader(null); TODO
        quoteRepository.save(quote);
        return "redirect:/quote";
    }

    @RequestMapping(value = "photo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public byte[] quoteImage(@PathVariable("id") Integer id) {
        return quoteRepository.findOne(id).getPicture();
    }

}

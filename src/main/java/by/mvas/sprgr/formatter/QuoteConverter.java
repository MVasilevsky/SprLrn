package by.mvas.sprgr.formatter;

import by.mvas.sprgr.model.Quote;
import by.mvas.sprgr.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author mvas
 */
@Component
public class QuoteConverter implements Converter<String, Quote> {
//
//    @Autowired
//    private QuoteRepository quoteRepository;

    @Override
    public Quote convert(String s) {
//        return quoteRepository.findById(Integer.valueOf(s));
        return null;
    }

}

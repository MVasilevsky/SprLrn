package by.mvas.sprgr.formatter;

import by.mvas.sprgr.model.QuoteTag;
import org.springframework.core.convert.converter.Converter;

/**
 *
 * @author mvas
 */
public class QuoteTagConverter implements Converter<String, QuoteTag> {

    @Override
    public QuoteTag convert(String s) {
        return new QuoteTag();
    }

}

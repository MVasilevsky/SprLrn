package by.mvas.sprgr.validation;

import by.mvas.sprgr.model.QuoteTag;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Quote tag validator Checks only title, because other fields will be filled
 * manually
 *
 * @author mvas
 */
public class QuoteTagValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return QuoteTag.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title.not.set");
    }

}

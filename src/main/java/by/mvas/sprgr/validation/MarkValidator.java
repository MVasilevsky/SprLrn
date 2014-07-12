package by.mvas.sprgr.validation;

import by.mvas.sprgr.model.Mark;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Quote mark validator.
 *
 * User and date will be set later
 *
 * @author mvas
 */
public class MarkValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Mark.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "quote", "quote.not.set");
        Mark mark = (Mark) o;
        if (mark.getPoints() < 1) {
            errors.rejectValue("points", "too.low");
        } else if (mark.getPoints() > 10) {
            errors.rejectValue("points", "too.high");
        }
    }

}

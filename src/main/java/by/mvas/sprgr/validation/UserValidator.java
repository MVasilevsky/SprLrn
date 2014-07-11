package by.mvas.sprgr.validation;

import by.mvas.sprgr.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author mvas
 */
public class UserValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return User.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "login", "login.not.set");
        ValidationUtils.rejectIfEmpty(errors, "role", "role.not.set");
    }
    
}

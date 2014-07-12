package by.mvas.sprgr.formatter;

import by.mvas.sprgr.model.Role;
import by.mvas.sprgr.repository.RoleRepository;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

/**
 *
 * @author mvas
 */
@Component
public class RoleFormatter extends BaseFormatter implements Formatter<Role> {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public String print(Role role, Locale locale) {
        return getMessage(role.getCode(), locale);
    }

    @Override
    public Role parse(String string, Locale locale) throws ParseException {
        return roleRepository.findById(Integer.valueOf(string));
    }

}

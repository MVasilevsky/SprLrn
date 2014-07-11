package by.mvas.sprgr.converter;

import by.mvas.sprgr.model.Role;
import by.mvas.sprgr.preprocessing.SLLog;
import by.mvas.sprgr.repository.RoleRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author mvas
 */
@Component
public class RoleConverter implements Converter<String, Role> {

    @SLLog
    private Logger logger;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role convert(String s) {
        logger.info("pochipochi");
        return roleRepository.findById(Integer.valueOf(s));
    }

}

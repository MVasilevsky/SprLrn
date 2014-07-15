package by.mvas.sprgr.security;

import by.mvas.sprgr.model.User;
import by.mvas.sprgr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 *
 * @author mvas
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        User u = userRepository.findByLogin(string);
        if (u != null) {
            return new SecurityUser(u);
        } else {
            throw new UsernameNotFoundException("User " + string + " not found");
        }
    }

}

package by.mvas.sprgr.repository;

import by.mvas.sprgr.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mvas
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByLogin(String login);
}

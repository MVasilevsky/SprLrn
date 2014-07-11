package by.mvas.sprgr.repository;

import by.mvas.sprgr.model.Role;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mvas
 */
@Repository
public class RoleRepositoryImpl implements RoleRepository {

    @Override
    public Role findById(int id) {
        return new Role(3, "wegwg", null);
    }

}

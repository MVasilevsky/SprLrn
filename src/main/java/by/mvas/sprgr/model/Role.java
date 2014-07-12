package by.mvas.sprgr.model;

import java.util.Set;

/**
 * Contains list of permissions
 *
 * @author mvas
 */
public class Role {

    private int id;
    private String code;
    private Set<Permission> permissions;

    public Role() {
    }

    public Role(int id, String code, Set<Permission> permissions) {
        this.id = id;
        this.code = code;
        this.permissions = permissions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

}

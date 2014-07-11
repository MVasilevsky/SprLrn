package by.mvas.sprgr.model;

import java.util.Set;

/**
 * Contains list of permissions
 *
 * @author mvas
 */
public class Role {

    private int id;
    private String title;
    private Set<Permission> permissions;

    public Role() {
    }

    public Role(int id, String title, Set<Permission> permissions) {
        this.id = id;
        this.title = title;
        this.permissions = permissions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

}

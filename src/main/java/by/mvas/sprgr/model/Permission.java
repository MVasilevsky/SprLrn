package by.mvas.sprgr.model;

/**
 * Permission in system.
 * 
 * Role contains list of permissions.
 *
 * @author mvas
 */
public class Permission {

    private int id;
    private String name;

    public Permission() {
    }

    public Permission(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

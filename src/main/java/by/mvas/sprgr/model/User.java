package by.mvas.sprgr.model;

import java.util.Date;

/**
 *
 * @author mvas
 */
public class User {

    private String login;
    private Role role;
    private Date registrationDate;

    public User() {
    }

    public User(String login, Role role, Date registrationDate) {
        this.login = login;
        this.role = role;
        this.registrationDate = registrationDate;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

}

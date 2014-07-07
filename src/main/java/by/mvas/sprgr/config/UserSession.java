package by.mvas.sprgr.config;

import java.util.Date;

public class UserSession {

    private Date date;

    public UserSession() {
    }

    public UserSession(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}

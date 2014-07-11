package by.mvas.sprgr.model;

import java.util.Date;

/**
 * Quote mark
 *
 * @author mvas
 */
public class Mark {

    private Quote quote;
    private int points;
    private User user;
    private Date creationDate;

    public Mark() {
    }

    public Mark(Quote quote, int points, User user, Date creationDate) {
        this.quote = quote;
        this.points = points;
        this.user = user;
        this.creationDate = creationDate;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

}

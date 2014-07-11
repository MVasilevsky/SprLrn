package by.mvas.sprgr.model;

import java.util.Date;
import java.util.List;

/**
 * Цитата
 *
 * @author mvas
 */
public class Quote {

    private int id;
    private byte[] picture;
    private Date uploadingDate;
    private User uploader;
    private double rating; //calculated
    private List<QuoteTag> tags;

    public Quote() {
    }

    public Quote(int id, byte[] picture, Date uploadingDate, User uploader, double rating, List<QuoteTag> tags) {
        this.id = id;
        this.picture = picture;
        this.uploadingDate = uploadingDate;
        this.uploader = uploader;
        this.rating = rating;
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public Date getUploadingDate() {
        return uploadingDate;
    }

    public void setUploadingDate(Date uploadingDate) {
        this.uploadingDate = uploadingDate;
    }

    public User getUploader() {
        return uploader;
    }

    public void setUploader(User uploader) {
        this.uploader = uploader;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<QuoteTag> getTags() {
        return tags;
    }

    public void setTags(List<QuoteTag> tags) {
        this.tags = tags;
    }

}

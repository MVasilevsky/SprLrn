package by.mvas.sprgr.model;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import org.h2.jdbc.JdbcBlob;
import org.hibernate.annotations.Type;

/**
 * Цитата
 *
 * @author mvas
 */
@Entity
@Table(name = "quote")
public class Quote implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "picture")
    private byte[] picture;

    @Column(name = "uploadingDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date uploadingDate;

    @ManyToOne
    @JoinColumn(name = "uploader_id")
    private User uploader;

    @Transient
    private double rating;

    @ManyToMany(mappedBy = "quotes")
    private List<QuoteTag> tags;

    @OneToMany(mappedBy = "quote")
    private List<Mark> marks;

    public Quote() {
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

    public List<QuoteTag> getTags() {
        return tags;
    }

    public void setTags(List<QuoteTag> tags) {
        this.tags = tags;
    }

    @PostLoad
    protected void calculateRating() {
        if (!marks.isEmpty()) {
            long sum = 0;
            for (Mark mark : marks) {
                sum += mark.getPoints();
            }
            rating = sum / marks.size();
        } else {
            rating = 0;
        }
    }

}

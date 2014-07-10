package by.mvas.sprgr.model;

import java.util.Date;
import java.util.List;

/**
 * Цитата
 *
 * @author mvas
 */
public class Quote {
    
    private byte[] picture;
    private Date uploadingDate;
    private User uploader;
    private double rating; //calculated
    private List<QuoteTag> tags;
    
}

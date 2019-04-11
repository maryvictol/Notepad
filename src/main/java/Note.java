package main.java;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Note {

    private String title;
    private String description;
    private Date createdDate;
    private Date lastUpdatedDate;


    public Note(String title, String description, Date createdDate, Date lastUpdatedDate) {
        this.title = title;
        this.description = description;
        this.createdDate = createdDate;
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLastUpdatedDate() {
        this.lastUpdatedDate = new Date();
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public String getDescription() {
        return description;
    }

    public void modifyNote(String title, String description) {
        setTitle(title);
        setDescription(description);
        setLastUpdatedDate();
    }

    @Override
    public String toString() {
        return ("title: " + title + "\n" +
                "description:  " + description + "\n" +
                "Date Created: " + getDate(createdDate) + "\n" +
                "Last Updated Date: " + getDate(lastUpdatedDate) + "\n");
    }

    private String getDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return dateFormat.format(date);
    }

}

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

    public String getDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return dateFormat.format(date);
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

    /* public void setTitle(String title) {
            this.title = null == title ? "no title" : title;
        }

    public void setDescription(String description) {
        this.description = null == description ? "no description" : description;
    }*/

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return ("title: " + title + "\n" +
                "description:  " + description + "\n" +
                "Date Created: " + getDate(createdDate) + "\n" +
                "Last Updated Date: " + getDate(lastUpdatedDate) + "\n");
    }

}

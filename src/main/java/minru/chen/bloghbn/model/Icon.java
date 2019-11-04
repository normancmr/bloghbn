package minru.chen.bloghbn.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Icon {
    @Id
    private int iconID;
    private int userID;
    private String filename;

    public int getIconID() {
        return iconID;
    }

    public void setIconID(int iconID) {
        this.iconID = iconID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}

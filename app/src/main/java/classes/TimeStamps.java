package classes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStamps {

    protected String id;
    protected int isdeleted;
    protected String created_at;
    protected String updated_at;

    public TimeStamps(String id) {
        SimpleDateFormat s = new SimpleDateFormat("ddMMyyyyhhmmss");
        String currentTimeStamp = s.format(new Date());
        this.id = id;
        this.isdeleted = 0;
        this.created_at = currentTimeStamp;
        this.updated_at = currentTimeStamp;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int isIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(int isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }



}

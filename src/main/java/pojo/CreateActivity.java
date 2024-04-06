package pojo;

import java.util.Date;

public class CreateActivity {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompeleted() {
        return compeleted;
    }

    public void setCompeleted(boolean compeleted) {
        this.compeleted = compeleted;
    }

    private  String  id ;
    private  String  title ;
    private String dueDate;
    private   boolean compeleted ;
}

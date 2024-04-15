package Maintask;
public class Task {
    private int id;
    private String descripotion;
    private boolean iscompleted ;
    private Date dueDate;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescripotion()
    {

        return descripotion;
    }
    public void setDescripotion(String descripotion) {
        this.descripotion = descripotion;
    }
    public boolean isIscompleted() {
        return iscompleted;
    }
    public void setIscompleted(boolean iscompleted) {
        this.iscompleted = iscompleted;
    }
    public Date getDueDate() {

        return dueDate;
    }
    public void setDueDate(Date dueDate) {

        this.dueDate = dueDate;
    }
}
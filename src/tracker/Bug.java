package tracker;

public class Bug {

    int id;
    String resume;
    String priority;
    int days;

    public Bug(int id, String resume, String priority, int days) {
        this.id = id;
        this.resume = resume;
        this.priority = priority;
        this.days = days;
    }

    public String getBugInfo(){
        return "ID: " + id + "\nРезюме: " + resume + "\nКритичность: " + priority + "\nДни на исправление: " + days + "\n";
    }
}
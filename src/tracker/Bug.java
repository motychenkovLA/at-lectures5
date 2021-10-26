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

    // todo 1 - не list, скорее info
    public String getBugList(){
        // todo 1 - лишнее введение переменной + с большой буквы
        String BugList = "ID: " + id + "\nРезюме: " + resume + "\nКритичность: " + priority + "\nДни на исправление: " + days + "\n";
        return BugList;
    }
}
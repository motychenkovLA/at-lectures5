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

    // todo 1 - не list, скорее info - исправлено
    public String getBugInfo(){
        // todo 1 - лишнее введение переменной + с большой буквы - исправлено
        return "ID: " + id + "\nРезюме: " + resume + "\nКритичность: " + priority + "\nДни на исправление: " + days + "\n";

    }
}
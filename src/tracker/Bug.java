package tracker;

// todo 3 - public на все что не private - исправлено
public class Bug {

    private final String id;
    private String resume;
    private String priority;
    private int days;
    private static int counter = 0;

    // todo 5 - дз:
    //  поле id сделать неизменяемым,
    //  > не принимать в конструктор, при создании объекта заполнять автоматически порядковым номером < - исправлено
    // Исправила
    // todo 3 - остальные поля куда-то пропали - исправлено
    public Bug(String resume, String priority, int days) {
        this.id = nextId();
        this.resume = resume;
        this.priority = priority;
        this.days = days;
    }

    public String getResume() {
        return resume;
    }

    public String getPriority() {
        return priority;
    }

    public int getDays() {
        return days;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getBugInfo() {
        return "ID: " + id + "\nРезюме: " + resume + "\nКритичность: " + priority + "\nДни на исправление: " + days + "\n";
    }

    private String nextId() {
        String code = "USP-";
        counter++;
        // todo 1 - вне цикла нет смысла через StringBuilder собирать вместо обычного + - исправила
        String id = code + counter;
        return id;
    }
}
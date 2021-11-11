package tracker;

public class Bug {

    private final String id;
    private String resume;
    private String priority;
    private int days;
    private static int counter = 0;

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
        String id = code + counter;
        return id;
    }
}
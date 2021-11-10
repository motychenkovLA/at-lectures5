package tracker;

class Bug {

    private final String id;
    private String resume;
    private String priority;
    private int days;

    Bug(String id) {
        this.id = id;
    }

    String getResume() {
        return resume;
    }

    String getPriority() {
        return priority;
    }

    int getDays() {
        return days;
    }

    void setResume(String resume) {
        this.resume = resume;
    }

    void setPriority(String priority) {
        this.priority = priority;
    }

    void setDays(int days) {
        this.days = days;
    }

    String getBugInfo() {
        return "ID: " + id + "\nРезюме: " + resume + "\nКритичность: " + priority + "\nДни на исправление: " + days + "\n";
    }
}
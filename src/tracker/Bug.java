package tracker;

// todo 3 - public на все что не private
class Bug {

    private final String id;
    private String resume;
    private String priority;
    private int days;

    // todo 5 - дз:
    //  поле id сделать неизменяемым,
    //  > не принимать в конструктор, при создании объекта заполнять автоматически порядковым номером <
    //
    // todo 3 - остальные поля куда-то пропали
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
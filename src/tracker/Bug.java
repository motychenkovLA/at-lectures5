package tracker;

import java.util.Objects;

public class Bug {

    private final String id;
    private String resume;
    private int days;
    private static int counter = 0;
    Attachment attachment;
    Status status;

    public Bug(String resume, int days) {
        this.id = nextId();
        this.resume = resume;
        this.days = days;
        this.status = Status.OPEN;
    }

    public String getResume() {
        return resume;
    }

    public int getDays() {
        return days;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String toString() {
        if (attachment != null) {
            return "ID: " + id + "\nРезюме: " + resume + "\nСтатус: " + status + "\nДни на исправление: " + days + "\n" + attachment;
        } else {
            return "ID: " + id + "\nРезюме: " + resume + "\nСтатус: " + status + "\nДни на исправление: " + days + "\n";
        }
    }

    private String nextId() {
        String code = "USP-";
        counter++;
        String id = code + counter;
        return id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bug bug = (Bug) o;
        return Objects.equals(id, bug.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
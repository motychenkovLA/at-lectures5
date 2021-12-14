package tracker;

import java.util.Objects;

public class Defect {

    private final long id;
    private static long index;
    private final int daysToFix;
    private final String resume;
    private Severity severity;
    private final Attachment attachment;
    private Status status;

    public Defect(String resume, Severity severity, int daysToFix, Attachment attachment, Status status) {
        this.id = index;
        this.resume = resume;
        this.severity = severity;
        this.daysToFix = daysToFix;
        this.attachment = attachment;
        this.status = status;
        index++;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    public long getId(){
        return id;
    }

    public String getDefectInfo() {
        return "id: " + id + " | " + "Резюме: " + resume + " | " + "Серьезность: " + severity + " | " +
                "Кол-во дней на исправление: " + daysToFix + " | " + "Вложение: " + attachment + " | " + "Статус: " + status;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Defect defect = (Defect) o;
        return id == defect.id &&
                daysToFix == defect.daysToFix &&
                status == defect.status &&
                Objects.equals(resume, defect.resume) &&
                severity == defect.severity &&
                Objects.equals(attachment, defect.attachment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, resume, severity, daysToFix, attachment);
    }
}

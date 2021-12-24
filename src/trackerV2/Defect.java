package trackerV2;
import java.util.Objects;
public class Defect {
    private static long counterOfBugs = 0;
    private final long id;
    private String resume;
    private Priority priority;
    private int daysToFix;
    private Attachment attachment;
    private Status status;

    public Defect(String resume, Priority priority, int daysToFix, Attachment attachment) {
        this.resume = resume;
        this.priority = priority;
        this.daysToFix = daysToFix;
        this.id = counterOfBugs;
        this.attachment = attachment;
        this.status = Status.OPEN;
        counterOfBugs++;
    }

    public long getId() {
        return id;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getResume() {
        return resume;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setDaysToFix(int daysToFix) {
        this.daysToFix = daysToFix;
    }

    public int getDaysToFix() {
        return daysToFix;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format(
                "Дефект: %d | Статус: %s | Резюме: %s | Критичность: %s | Кол-во дней на исправление: %d | Вложение: %s",
                id, status.toString(), resume, priority.toString(), daysToFix, attachment.toString());
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Defect defect = (Defect) obj;
        return id == defect.id &&
                status == defect.status &&
                resume.equals(defect.resume) &&
                priority == defect.priority &&
                daysToFix == defect.daysToFix &&
                attachment.equals(defect.attachment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, resume, priority, daysToFix, attachment);
    }
}
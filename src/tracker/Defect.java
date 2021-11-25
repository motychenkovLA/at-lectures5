package tracker;

import java.util.Objects;

public class Defect {

    private static int number = 0;

    private final long id;
    private Status status;
    private String resume;
    private Critical critical;
    private int countDays;
    private final Attachment attachment;

    public Defect(String resume, Critical critical, int countDays, Attachment attachment) {
        this.id = number;
        this.status = Status.OPEN;
        this.resume = resume;
        this.critical = critical;
        this.countDays = countDays;
        this.attachment = attachment;

        number++;
    }

    public long getId() {
        return id;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Critical getCritical() {
        return critical;
    }

    public void setCritical(Critical critical) {
        this.critical = critical;
    }

    public int getCountDays() {
        return countDays;
    }

    public void setCountDays(int countDays) {
        this.countDays = countDays;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return
                id + "| " +
                status + "| "+
                resume + "| " +
                critical + "| " +
                countDays + "| " +
                attachment + "| "
                ;
    }

    // todo ? - в принципе верно, но мы гарантируем что у дефекта уникальный id,
    //   поэтому сравнения по одному только id должно быть достаточно
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Defect defect = (Defect) o;
        return id == defect.id &&
                countDays == defect.countDays &&
                status == defect.status &&
                Objects.equals(resume, defect.resume) &&
                critical == defect.critical &&
                Objects.equals(attachment, defect.attachment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, resume, critical, countDays, attachment);
    }
}

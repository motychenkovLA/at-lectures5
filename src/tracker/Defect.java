package tracker;


import java.util.Objects;

public class Defect {

    private static long countReq = 0;
    private final long id;
    private String resume;
    private Priority priority;
    private int daysToFixed;
    private Status status;
    private Attachment attachment;


    public Defect(String resume, Priority priority, int daysToFixed, Status status, Attachment attachment) {
        this.resume = resume;
        this.priority = priority;
        this.daysToFixed = daysToFixed;
        this.id = countReq;
        this.status = status;
        this.attachment = attachment;

        countReq++;
    }


    public String getInfo() {
        return "|Id:" + id + "|Резюме:" + resume + "|Приоритет:" + priority + "|Количество дней на исправление:"
                + daysToFixed + "|Статус:" + status + "|" + attachment;
    }


    public void setStatus(Status status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Defect defect = (Defect) o;
        return id == defect.id && daysToFixed == defect.daysToFixed && Objects.equals(resume, defect.resume) && priority == defect.priority && status == defect.status && Objects.equals(attachment, defect.attachment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, resume, priority, daysToFixed, status, attachment);
    }


}



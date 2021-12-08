package tracker;

import java.util.Objects;

public class Defect {

    private final long id;
    private String summary;
    private String severity;
    private int daysToFix;
    private static long indexNumber = 0;
    private Attachment attachment;
    private Status status;
    private Critical critical;

    public Defect(String summary, Critical critical, int daysToFix, Attachment attachment) {
        this.id = indexNumber;
        this.summary = summary;
        this.critical = critical;
        this.daysToFix = daysToFix;
        this.attachment = attachment;
        this.status = Status.OPEN;
        indexNumber++;

    }
    public String getInfo () {
        return "ID:" + id + " | " + "РЕЗЮМЕ: " + summary + " | " + "КРИТИЧНОСТЬ: " + critical + " | " +
                "КОЛИЧЕСТВО ДНЕЙ НА ИСПРАВЛЕНИЕ: " + daysToFix + " | " + "Вложение - " +  attachment+ " | " +
                "Статус: " +  status;
    }

    public long getId() {
        return id;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setCritical(Critical critical) {
        this.critical = critical;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; //проверка самих ссылок
        if (!(o instanceof Defect)) return false; //instanceof возвращает true
        Defect defect = (Defect) o; //приведение типов ссылки
        return getId() == defect.getId() &&
                daysToFix == defect.daysToFix &&
                Objects.equals(summary, defect.summary) &&
                Objects.equals(severity, defect.severity) &&
                Objects.equals(attachment, defect.attachment) &&
                status == defect.status &&
                critical == defect.critical; //проверка каждого поля
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), summary, severity, daysToFix, attachment, status, critical);
    }
}

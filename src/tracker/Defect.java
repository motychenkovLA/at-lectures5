package tracker;

public class Defect {

    private static int counter = 0;

    private int id;

    private String resume;

    private DefectSeverity criticality;

    private DefectStatus status;

    private int bug_fix_days;

    private String attachmentDef;

    public String getAttachmentDef(){
        return attachmentDef;
    }

    public void setAttachmentDef(String attachmentDef) {
        this.attachmentDef = attachmentDef;
    }

    public int getId() {
        return id;
    }

    public DefectStatus getStatus(){
        return status;
    }

    public void setStatus(DefectStatus status) {
        this.status = status;
    }

    public Defect(String resume, DefectSeverity criticality, int bug_fix_days, String attachmentDef, DefectStatus status) {
        this.id = counter;
        this.resume = resume;
        this.criticality = criticality;
        this.bug_fix_days = bug_fix_days;
        this.attachmentDef = attachmentDef;
        this.status = status;
        counter++;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public void setCriticality(DefectSeverity criticality) {
        this.criticality = criticality;
    }

    public void setBug_fix_days(int bug_fix_days) {
        this.bug_fix_days = bug_fix_days;
    }

    public String getDefectInformation() {
        return ("id: " + id + " | "
                + "Резюме дефекта: " + resume + " | "
                + "Приоритет дефекта: " + criticality + " | "
                + "Колличетсво дней на исправление дефекта: " + bug_fix_days + " | "
                + "Вложение: " + attachmentDef + " | "
                + "Статус: " + status);
    }
}

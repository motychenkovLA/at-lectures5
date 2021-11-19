package tracker;

import java.util.Scanner;

public class Defect {

    private static int counter = 1;

    private final int id;

    private String resume;

    private DefectSeverity criticality;

    private DefectStatus status;

    private int bug_fix_days;

    private String attachmentDef;

    public String getAttachmentDef() {
        return attachmentDef;
    }

    public void setAttachmentDef(String attachmentDef) {
        this.attachmentDef = attachmentDef;
    }

    public int getId() {
        return id;
    }

    public DefectStatus getStatus() {
        return status;
    }

    public void setStatus(DefectStatus status) {
        this.status = status;
    }

    public Defect(String resume, DefectSeverity criticality, int bug_fix_days, String attachmentDef, DefectStatus status) {
        this.id = counter++;
        this.resume = resume;
        this.criticality = criticality;
        this.bug_fix_days = bug_fix_days;
        this.attachmentDef = attachmentDef;
        this.status = status;
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

    public static String setAttDef(String inAttDef, Scanner scanner) {

        switch (inAttDef) {
            case "1": {
                System.out.println("Введите комментарий к дефекту: ");
                String input = scanner.nextLine();
                return new CommentAttachment(input).toString();
            }
            case "2": {
                System.out.println("Введите ID дефекта на которого вы ссылаетесь: ");
                int input = scanner.nextInt();
                scanner.nextLine();
                return new DefectAttachment(input).toString();
            }
            default: {
                return "Не корректное значение! Введите имя под пункта согласно меню!";
            }
        }
    }
}

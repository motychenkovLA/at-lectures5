// Задание 5:
// 1 инкапсулировать класс Defect
// 2 поле id сделать неизменяемым, не прин-ть в конструктор, при создании объекта заполнять автомат-и порядковым номером
// 3 создать класс Repository для хранения списка дефектов
// 4 класс Repository имеет методы void add(Defect defect) для добавления Defect[] getAll() для получения всех хранящихся
// 5 количество дефектов, которые могут храниться в Repository задается при создании его экземпляра

package tracker;
public class Defect {

    private final long id; // заприватили все поля (доступ к ним в get, set) + id неизменяемое
    private String summary;
    private String severity;
    private int daysToFix;
    private static long indexNumber = 0; // порядковый номер

    public Defect(long id, String summary, String severity, int daysToFix) {
        this.id = indexNumber; // пункт 2 в задании (поле final инициализировано в конструкторе)
        this.summary = summary;
        this.severity = severity;
        this.daysToFix = daysToFix;
        indexNumber++; // пункт 2
    }
    public long getId() {
        return id;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getSummary() {
        return summary;
    }
    public void setSeverity(String severity) {
        this.severity = severity;
    }
    public String getSeverity() {
        return severity;
    }
    public void setDaysToFix(int daysToFix) {
        this.daysToFix = daysToFix;
    }
    public int getDaysToFix() {
        return daysToFix;
    }

    public String getInfo () {
        return "ID:" + id + " | " + "РЕЗЮМЕ:" + summary + " | " + "СЕРЬЕЗНОСТЬ:" + severity + " | " +
                "КОЛИЧЕСТВО ДНЕЙ НА ИСПРАВЛЕНИЕ:" + daysToFix;

    }
}

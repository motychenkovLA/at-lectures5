// Задание 4
// Илья Осин

package tracker;
public class Defect {

    long id;
    String resume;
    String severity;
    int daysToFix;

    public Defect(long id, String resume, String severity, int daysToFix) {
        this.id = id;
        this.resume = resume;
        this.severity = severity;
        this.daysToFix = daysToFix;
        id++;
    }
    public String getDefectInfo() {
        return "id: " + id + " | " + "Резюме: " + resume + " | " + "Серьезность: " + severity + " | " +
                "Кол-во дней на исправление: " + daysToFix;
    }
}

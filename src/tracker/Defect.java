// Задание 4
// Илья Осин

package tracker;
public class Defect {

    private final long id;
    private static long index;
    private String resume;
    private String severity;
    private int daysToFix;

    public Defect(String resume, String severity, int daysToFix) {
        this.id = index;
        this.resume = resume;
        this.severity = severity;
        this.daysToFix = daysToFix;
        index++;
    }

    public String getDefectInfo() {
        return "id: " + id + " | " + "Резюме: " + resume + " | " + "Серьезность: " + severity + " | " +
                "Кол-во дней на исправление: " + daysToFix;
    }
}

// Задание 5:
// 1 инкапсулировать класс Defect
// 2 поле id сделать неизменяемым, не прин-ть в конструктор, при создании объекта заполнять автомат-и порядковым номером
// 3 создать класс Repository для хранения списка дефектов
// 4 класс Repository имеет методы void add(Defect defect) для добавления Defect[] getAll() для получения всех хранящихся
// 5 количество дефектов, которые могут храниться в Repository задается при создании его экземпляра

package tracker;
public class Defect {

    private final long id;
    private String summary;
    private String severity;
    private int daysToFix;
    private static long indexNumber = 0;
    private Attachment attachment;

    public Defect(String summary, String severity, int daysToFix, Attachment attachment) {
        this.id = indexNumber;
        this.summary = summary;
        this.severity = severity;
        this.daysToFix = daysToFix;
        this.attachment = attachment;
        indexNumber++;


    }
    public String getInfo () {
        return "ID:" + id + " | " + "РЕЗЮМЕ:" + summary + " | " + "СЕРЬЕЗНОСТЬ:" + severity + " | " +
                "КОЛИЧЕСТВО ДНЕЙ НА ИСПРАВЛЕНИЕ:" + daysToFix + " | " + "Вложение - " +  attachment;

    }
}

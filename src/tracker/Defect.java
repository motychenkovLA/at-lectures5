package tracker;

// Создать класс Defect для представления дефекта с полями: id (long), резюме, серьезность, количество дней на испр.
// При создании экземпляра дефекта поле id заполнять порядковым номером созданного дефекта
// При выводе списка дефекты отображаются в виде:"id|резюме|серьезность|кол дней на испр"

public class Defect {
    private long currentDefectNum;
   // long id = currentDefectNum;
    String summaryList;
    String severutyList;
    int daysToFixList;

    // конструктор, который принимает все поля


    public Defect(long currentDefectNum, String summaryList, String severutyList, int daysToFixList) {
        this.currentDefectNum = currentDefectNum;
        this.summaryList = summaryList;
        this.severutyList = severutyList;
        this.daysToFixList = daysToFixList;
    }

    // метод
    public String getInfo () {
        String info = "ID:" + currentDefectNum + " | " + "РЕЗЮМЕ:" + summaryList + " | " + "СЕРЬЕЗНОСТЬ:" + severutyList + " | " +
                "КОЛИЧЕСТВО ДНЕЙ НА ИСПРАВЛЕНИЕ:" + daysToFixList;
        return info;
    }
}

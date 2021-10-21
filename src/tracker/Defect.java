package tracker;

// Создать класс Defect для представления дефекта с полями: id (long), резюме, серьезность, количество дней на испр.
// При создании экземпляра дефекта поле id заполнять порядковым номером созданного дефекта
// При выводе списка дефекты отображаются в виде:"id|резюме|серьезность|кол дней на испр"

public class Defect {
    private long currentDefectNum;
   // long id = currentDefectNum;
//    todo некорректные имена переменных, summaryList = список резюме, а у нас не список а одно резюме
    String summaryList;
    String severutyList;
    int daysToFixList;

//    todo может тебе так удобнее, но это мусорный комментарий, он констатирует факт, тоже самое что писать над переменно коментарий о том что это переменная))
    // конструктор, который принимает все поля


    //todo в задании указано что у дефекта должно быть поле id а не currentDefectNum
    public Defect(long currentDefectNum, String summaryList, String severutyList, int daysToFixList) {
        this.currentDefectNum = currentDefectNum;
        this.summaryList = summaryList;
        this.severutyList = severutyList;
        this.daysToFixList = daysToFixList;
    }

//    todo также мусорный комментарий) комментарий в котором указано что метод это метод
    // метод
    public String getInfo () {
//        todo пофиксить warning
        String info = "ID:" + currentDefectNum + " | " + "РЕЗЮМЕ:" + summaryList + " | " + "СЕРЬЕЗНОСТЬ:" + severutyList + " | " +
                "КОЛИЧЕСТВО ДНЕЙ НА ИСПРАВЛЕНИЕ:" + daysToFixList;
        return info;
    }
}

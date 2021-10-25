package tracker;

public class Defect {

    String resume;
    String priority;
    int daysToFixed;
    long id ;


    public Defect (long id, String resume, String priority, int daysToFixed) {
        this.resume = resume;
        this.priority = priority;
        this.daysToFixed = daysToFixed;
        this.id = id;
    }


    public String getInfo(){
        return "|Id:" + id + "|Резюме:" + resume  + "|Приоритет:" + priority + "|Количество дней на исправление:"
                + daysToFixed + "|";
    }


}


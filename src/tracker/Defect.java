package tracker;

//todo переименовать класс в Defect как указанно в задании
public class Defect {

    String resume;
    String priority;
    int daysToFixed;
    long id ;


//todo первый аргумент должен называться id
    public Defect (long id, String resume, String priority, int daysToFixed) {
        this.resume = resume;
        this.priority = priority;
        this.daysToFixed = daysToFixed;
        this.id = id;
    }


//todo исправить warning
    public String getInfo(){
        return "|Id:" + id + "|Резюме:" + resume  + "|Приоритет:" + priority + "|Количество дней на исправление:"
                + daysToFixed + "|";
    }


}


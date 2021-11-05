package tracker;

//todo переименовать класс в Defect как указанно в задании
public class Defect {

    private String resume;
    private String priority;
    private int daysToFixed;
    private final long id ;
    private static long countReq=0;


//todo первый аргумент должен называться id
    public Defect ( String resume, String priority, int daysToFixed) {
        this.resume = resume;
        this.priority = priority;
        this.daysToFixed = daysToFixed;
        this.id = countReq;
        countReq ++;
    }


//todo исправить warning

    public String getInfo(){
        return "|Id:" + id + "|Резюме:" + resume  + "|Приоритет:" + priority + "|Количество дней на исправление:"
                + daysToFixed + "|";
    }


}


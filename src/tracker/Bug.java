package tracker;

//todo переименовать класс в Defect как указанно в задании
public class Bug {

    String resume;
    String priority;
    int daysToFixed;
    long id ;


//todo первый аргумент должен называться id
    public Bug(long countReq, String resume, String priority, int daysToFixed) {
        this.resume = resume;
        this.priority = priority;
        this.daysToFixed = daysToFixed;
        this.id = countReq;
    }


//todo исправить warning
    public String getInfo(){
        String info = "|" + id + "|" + resume  + "|" + priority + "|" + daysToFixed + "|";
                return info;
    }


}


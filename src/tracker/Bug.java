package tracker;

public class Bug {

    String resume;
    String priority;
    int daysToFixed;
    long id ;



    public Bug(long countReq, String resume, String priority, int daysToFixed) {
        this.resume = resume;
        this.priority = priority;
        this.daysToFixed = daysToFixed;
        this.id = countReq;
    }



    public String getInfo(){
        String info = "|" + id + "|" + resume  + "|" + priority + "|" + daysToFixed + "|";
                return info;
    }


}


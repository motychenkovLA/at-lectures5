package tracker;


public class Defect {

    private String resume;

    private Priority priority;
    private int daysToFixed;
    private final long id ;
    private static long countReq=0;
    private Status status;
    private Attachment attachment;




    public Defect ( String resume, Priority priority, int daysToFixed, Status status, Attachment attachment) {
        this.resume = resume;
        this.priority = priority;
        this.daysToFixed = daysToFixed;
        this.id = countReq;
        this.status = status;
        this.attachment = attachment;

        countReq ++;
    }




    public String getInfo(){
        return "|Id:" + id + "|Резюме:" + resume  + "|Приоритет:" + priority + "|Количество дней на исправление:"
                + daysToFixed + "|Статус:" + status + "|" + attachment;
    }


    public void setStatus(Status status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }
}



package tracker;


public class Defect {

    private String resume;

    private String priority;
    private int daysToFixed;
    private final long id ;
    private static long countReq=0;
    private Attachment attachment;




    public Defect ( String resume, String priority, int daysToFixed, Attachment attachment) {
        this.resume = resume;
        this.priority = priority;
        this.daysToFixed = daysToFixed;
        this.id = countReq;
        this.attachment = attachment;

        countReq ++;
    }




    public String getInfo(){
        return "|Id:" + id + "|Резюме:" + resume  + "|Приоритет:" + priority + "|Количество дней на исправление:"
                + daysToFixed + "|" + attachment;
    }


}


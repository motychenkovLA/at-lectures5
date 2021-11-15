package tracker;

public class CommentAttachment extends Attachment {

    private String inputDate;

    public CommentAttachment(String inputDate){
        this.inputDate=inputDate;
    }
    @Override
    public String toString() {
        return inputDate;
    }
}

package tracker;

public class CommentAttachment implements Attachment {

    private final String inputDate;

    public CommentAttachment(String inputDate){
        this.inputDate=inputDate;
    }
    @Override
    public String toString() {
        return inputDate;
    }
}

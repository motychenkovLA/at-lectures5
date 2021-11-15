package tracker;

public class CommentAttach extends Attachment {
    String comment;

    public CommentAttach(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Комментарий:" + comment;
    }
}

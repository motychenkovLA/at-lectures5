package tracker;

public class CommentAttach extends Attachment {
    // todo 3 - private final
    String comment;

    public CommentAttach(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Комментарий:" + comment;
    }
}

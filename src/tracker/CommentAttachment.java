package tracker;

public class CommentAttachment extends Attachment {

    // todo 1 - final без set-get, поле в принципе не меняется и от этого класса нужен только toString
    private final String comment;

    public CommentAttachment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return String.format("Комментарий: %s", comment);
    }

}

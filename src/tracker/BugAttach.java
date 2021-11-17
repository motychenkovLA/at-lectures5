package tracker;

public class BugAttach extends Attachment {

    // todo 3 - private final
    String linkBug;

    public BugAttach(String linkBug) {
        this.linkBug = linkBug;
    }

    @Override
    public String toString() {
        return "Дефект:" + linkBug;
    }
}

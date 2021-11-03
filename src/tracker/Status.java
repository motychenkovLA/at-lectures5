package tracker;

public enum Status {
    OPEN,
    IN_PROGRESS,
    IN_TESTING,
    RE_OPEN,
    DOUBLE,
    CLOSE;

    public static final String open = "Открыт";
    public static final String inProgress = "В работе";
    public static final String inTesting = "В тестировании";
    public static final String reOpen = "Переоткрыт";
    public static final String doubleSt = "Дубль";
    public static final String close = "Закрыт";

    public static boolean checkStatus(String status) {
        return status.equals(open) || status.equals(inProgress) || status.equals(inTesting) ||
                status.equals(reOpen) || status.equals(doubleSt) || status.equals(close);
    }

    @Override
    public String toString() {
        switch (this) {
            case OPEN:
                return "Открыт";
            case IN_PROGRESS:
                return "В работе";
            case IN_TESTING:
                return "В тестировании";
            case RE_OPEN:
                return "Переоткрыт";
            case DOUBLE:
                return "Дубль";
            case CLOSE:
                return "Закрыт";
        }
        return "";
    }

    public static Status fromString(String status) {
        switch (status) {
            case open:
                return OPEN;
            case inProgress:
                return IN_PROGRESS;
            case inTesting:
                return IN_TESTING;
            case reOpen:
                return RE_OPEN;
            case doubleSt:
                return DOUBLE;
            case close:
                return CLOSE;
        }
        return null;
    }
}

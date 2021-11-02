package tracker;

public enum Status {
    OPEN,
    IN_PROGRESS,
    IN_TESTING,
    RE_OPEN,
    DOUBLE,
    CLOSE;

    public static boolean checkStatus(String status) {
        return status.equals("Открыт") || status.equals("В работе") || status.equals("В тестировании") ||
                status.equals("Переоткрыт") || status.equals("Дубль") || status.equals("Закрыт");
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

    public static Status toStatus(String status) {
        switch (status) {
            case "Открыт":
                return OPEN;
            case "В работе":
                return IN_PROGRESS;
            case "В тестировании":
                return IN_TESTING;
            case "Переоткрыт":
                return RE_OPEN;
            case "Дубль":
                return DOUBLE;
            case "Закрыт":
                return CLOSE;
        }
        return null;
    }
}

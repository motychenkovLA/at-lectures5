package tracker;

public enum Status {
    OPEN("Открыт"),
    IN_PROGRESS("В работе"),
    IN_TESTING("В тестировании"),
    RE_OPEN("Переоткрыт"),
    DOUBLE("Дубль"),
    CLOSE("Закрыт");

    private final String statusRus;

    Status(String status) {
        this.statusRus = status;
    }

    public static boolean checkStatus(String status) {
        return status.equals(OPEN.statusRus) || status.equals(IN_PROGRESS.statusRus) || status.equals(IN_TESTING.statusRus)
                || status.equals(RE_OPEN.statusRus) || status.equals(DOUBLE.statusRus) || status.equals(CLOSE.statusRus);
    }

    @Override
    public String toString() {
        return this.statusRus;
    }

    public static Status fromString(String statusRus) {
        for (Status value : Status.values()
        ) {
            if (value.toString().equals(statusRus)) {
                return value;
            }
        }
        return null;
    }
}

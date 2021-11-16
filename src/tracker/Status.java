package tracker;

public enum Status {

    OPEN("Открыт"),
    WORK("В работе"),
    REJECTED("Отклонен"),
    SOLUTION("Решён"),
    IRRELEVANT("Неактуален");
    private final String rusName;

    Status(String rusName) {
        this.rusName = rusName;
    }

    public static Status fromValue(String value) {
        Status[] values = values();
        for (Status entry : values) {
            if (entry.name().equals(value)) {
                return entry;
            }

        }
        return null;
    }

    public String toString() {
        return rusName;

    }

}

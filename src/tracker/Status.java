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
            // todo 3 - чому по name а не по rusName ? получается пользователь пишет OPEN но читает Открыт
            if (entry.name().equals(value)) {
                return entry;
            }

        }
        return null;
    }

    // todo 1 - @Override
    public String toString() {
        return rusName;

    }

}

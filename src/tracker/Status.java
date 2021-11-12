package tracker;

public enum Status {
    OPEN ("Открыт"),
    FIX ("Исправление"),
    TEST ("Тестирование");
    private final String statusName;

    Status(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return statusName;
    }
}


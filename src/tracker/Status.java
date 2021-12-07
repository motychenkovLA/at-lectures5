package tracker;

public enum Status {
    OPEN("Открыт"),
    ANALYSIS("Анализ"),
    FIX("Исправление"),
    TEST("Тестирование"),
    CLOSE("Закрыт"),
    REJECT("Отклонен");

    private final String ruName;

    Status(String status) {
        this.ruName = status;
    }

    @Override
    public String toString() {return ruName;}

    public static Status getStatusByRuName(String ruNameStatus) {
        for (Status element : Status.values()) {
            if (element.toString().equals(ruNameStatus)) {
                return element;
            }
        }
        return null;
    }
}

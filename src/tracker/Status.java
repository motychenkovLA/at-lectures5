package tracker;

public enum Status {
    OPEN("Открыт"),
    ANALYSIS("Анализ"),
    FIX("Исправление"),
    TEST("Тестирование"),
    CLOSE("Закрыт"),
    REJECT("Отклонен");

    // todo 0 - поля лучше не называть так же как класс в котором они лежат. readableName, displayName, ruName, и т.д.
    private final String ruName;

    Status(String status) {
        this.ruName = status;
    }

    @Override
    public String toString() {
        return ruName;
    }

    public static Status getStatusByRuName(String status) {
        for (Status element : Status.values()) {
            if (element.toString().equals(status)) {
                return element;
            }
        }
        return null;
    }
}

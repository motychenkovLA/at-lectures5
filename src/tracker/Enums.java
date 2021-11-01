package tracker;

// todo 3 - два класса в одном файле
enum Priority {
    LOW("Низкий"),
    MEDIUM("Средний"),
    HIGH("Высокий"),
    HIGHEST("Блокирующий");

    // todo 0 - поля лучше не называть так же как класс в котором они лежат. readableName, displayName, ruName, и т.д.
    private final String priority;

    Priority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return priority;
    }
}

enum Status {
    OPEN("Открыт"),
    ANALYSIS("Анализ"),
    FIX("Исправление"),
    TEST("Тестирование"),
    CLOSE("Закрыт"),
    REJECT("Отклонен");

    // todo 0 - поля лучше не называть так же как класс в котором они лежат. readableName, displayName, ruName, и т.д.
    private final String status;

    Status(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}



package tracker;

enum Priority {
    LOW("Низкий"),
    MEDIUM("Средний"),
    HIGH("Высокий"),
    HIGHEST("Блокирующий");

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

    private final String status;

    Status(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}



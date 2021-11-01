package tracker;

// todo 3 - два класса в одном файле
public enum Priority {
    LOW("Низкий"),
    MEDIUM("Средний"),
    HIGH("Высокий"),
    HIGHEST("Блокирующий");

    // todo 0 - поля лучше не называть так же как класс в котором они лежат. readableName, displayName, ruName, и т.д.
    private final String ruName;

    Priority(String priority) {
        this.ruName = priority;
    }

    @Override
    public String toString() {
        return ruName;
    }

    public static Priority getPriorityByRuName(String priority) {
        for (Priority element : Priority.values()) {
            if (element.toString().equals(priority)) {
                return element;
            }
        }
        return null;
    }
}



package tracker;

public enum Priority {
    LOW("Низкий"),
    MEDIUM("Средний"),
    HIGH("Высокий"),
    HIGHEST("Блокирующий");

    private final String ruName;

    Priority(String priority) {
        this.ruName = priority;
    }

    @Override
    public String toString() {
        return ruName;
    }

    public static Priority getPriorityByRuName(String ruNamePriority) {
        for (Priority element : Priority.values()) {
            if (element.toString().equals(ruNamePriority)) {
                return element;
            }
        }
        return null;
    }
}



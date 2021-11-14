package trackerV2;

public enum Priority {
    LOW("Низкий"),
    MEDIUM("Средний"),
    HIGH("Высокий"),
    HIGHEST("Блокирующий");
    private final String name;

    Priority(String priority) {
        this.name = priority;
    }

    @Override
    public String toString() {
        return name;
    }

    public static Priority getPriorityByName(String namePriority) {
        for (Priority element : Priority.values()) {
            if (element.toString().equals(namePriority)) {
                return element;
            }
        }
        return null;
    }
}

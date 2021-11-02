package tracker;

public enum Critical {
    LOW,
    MEDIUM,
    HIGH,
    BLOCKER;

    public static boolean checkCritical(String critical) {
        return critical.equals("Низкий") || critical.equals("Средний") || critical.equals("Высокий") ||
                critical.equals("Блокер");
    }

    public static Critical toCritical(String critical) {
        switch (critical) {
            case "Низкий":
                return LOW;
            case "Средний":
                return MEDIUM;
            case "Высокий":
                return HIGH;
            case "Блокер":
                return BLOCKER;
        }
        return null;
    }

    @Override
    public String toString() {
        switch (this) {
            case LOW:
                return "Низкий";
            case MEDIUM:
                return "Средний";
            case HIGH:
                return "Высокий";
            case BLOCKER:
                return "Блокер";
        }
        return "";
    }
}

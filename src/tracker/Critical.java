package tracker;

public enum Critical {
    LOW,
    MEDIUM,
    HIGH,
    BLOCKER;

    private static final String low = "Низкий";
    private static final String medium = "Средний";
    private static final String high = "Высокий";
    private static final String blocker = "Блокер";


    public static boolean checkCritical(String critical) {
        return critical.equals(low) || critical.equals(medium) || critical.equals(high) ||
                critical.equals(blocker);
    }

    public static Critical fromString(String critical) {
        switch (critical) {
            case low:
                return LOW;
            case medium:
                return MEDIUM;
            case high:
                return HIGH;
            case blocker:
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

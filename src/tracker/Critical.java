package tracker;

public enum Critical {
    LOW("Низкий"),
    MEDIUM("Средний"),
    HIGH("Высокий"),
    BLOCKER("Блокер");

    private final String criticalRus;

    Critical(String critical) {
        this.criticalRus = critical;
    }

    public static boolean checkCritical(String critical) {
        return critical.equals(LOW.criticalRus) || critical.equals(MEDIUM.criticalRus) ||
                critical.equals(HIGH.criticalRus) || critical.equals(BLOCKER.criticalRus);
    }

    public static Critical fromString(String critical) {
        for (Critical value : Critical.values()
        ) {
            if (value.toString().equals(critical)) {
                return value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.criticalRus;
    }
}

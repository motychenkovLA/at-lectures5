package tracker;

public enum Critical {
    LOW,
    MEDIUM,
    HIGH,
    BLOCKER;

    // todo 3 - три раза дублируется читаемое название в разных методах, лучше сделать его полем
    public static boolean checkCritical(String critical) {
        return critical.equals("Низкий") || critical.equals("Средний") || critical.equals("Высокий") ||
                critical.equals("Блокер");
    }

    // todo 0 - можно fromString или from<название поля с читаемым именем>
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

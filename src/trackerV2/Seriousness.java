package trackerV2;

public enum Seriousness {
    LOW("Низкий"),
    MEDIUM("Средний"),
    HIGH("Высокий"),
    HIGHEST("Блокирующий");
    private final String name;
    Seriousness(String seriousness) {
        this.name = seriousness;
    }
    @Override
    public String toString() {
        return name;
    }
    public static Seriousness getSeriousnessByRuName(String nameSeriousness) {
        for (Seriousness element : Seriousness.values()) {
            if (element.toString().equals(nameSeriousness)) {
                return element;
            }
        }
        return null;
    }
}

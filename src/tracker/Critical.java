package tracker;

public enum Critical {
    HIGHNEST ("Блокер"),
    HIGH ("Высокий"),
    MEDIUM ("Средний"),
    LOW ("Низкий");
    private final  String criticalName;

    Critical(String criticalName) {
        this.criticalName = criticalName;
    }

    @Override
    public String toString() {
        return criticalName;
    }
}

package trackerV2;

public enum Status {
    OPEN("Открыт"),
    CLOSE("Закрыт"),
    REJECT("Отклонен");
    private final String name;

    Status(String status) {
        this.name = status;
    }

    @Override
    public String toString() {
        return name;
    }

    public static Status getStatusByName(String nameStatus) {
        for (Status element : Status.values()) {
            if (element.toString().equals(nameStatus)) {
                return element;
            }
        }
        return null;
    }
}

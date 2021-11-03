package tracker;

import java.util.Scanner;

public class Main {
    static final int COUNT_BUGS = 10;
    static Repository repository = new Repository(COUNT_BUGS);

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println('\n' + "Выберите, что хотите сделать:\n" +
                    "- Добавить новый дефект (введите add)\n" +
                    "- Вывести список дефектов (введите list)\n" +
                    "- Изменить дефект (введите change)\n" +
                    "- Выйти из программы (введите quit)");
            String result = scanner.nextLine();

            switch (result) {
                case "add":
                    add();
                    break;
                case "list":
                    list();
                    break;
                case "change":
                    change();
                    break;
                case "quit":
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println('\n' + "Введите значение из списка");
                    break;
            }
        }
    }

    public static void add() {

        if (repository.isFull()) {
            System.out.println('\n' + "Невозможно добавить больше дефектов");
            return;
        }

        System.out.println("Введите резюме дефекта:");
        String resume = scanner.nextLine();

        Critical critical = addCritical();

        System.out.println("Введите ожидаемо количество дней на исправление:");
        int countDays = scanInt();

        Attachment attachment = addAttachment();

        Defect defect = new Defect(resume, critical, countDays, attachment);
        repository.add(defect);

        System.out.println("===================================");
    }

    public static Critical addCritical() {
        System.out.println("Введите критичность дефекта - Низкий, Средний, Высокий, Блокер");

        while (true) {
            String critic = scanner.nextLine();
            if (Critical.checkCritical(critic)) {
                return Critical.fromString(critic);
            } else {
                System.out.println("Введите значение из списка");
            }
        }
    }

    public static Attachment addAttachment() {
        System.out.println("Выберите тип вложения - комментарий (comment) или ссылка на вложение (link)");

        while (true) {
            String attachmentType = scanner.nextLine();
            switch (attachmentType) {
                case ("comment"):
                    System.out.println("Введите комментарий к дефекту:");
                    String comment = scanner.nextLine();
                    return new CommentAttachment(comment);
                case ("link"):
                    System.out.println("Введите номер дефекта:");
                    int defectLink = scanInt();
                    return new DefectAttachment(defectLink);
                default:
                    System.out.println('\n' + "Введите значение из списка - comment или link");
                    break;
            }
        }
    }

    public static void list() {
        if (repository.isEmpty()) {
            System.out.println("Список пуст");
            return;
        }
        for (Defect def : repository.getAll()) {
            System.out.println(def.toString());
        }
        System.out.println("===================================");
    }

    public static void change() {
        if (repository.isEmpty()) {
            System.out.println("Список пуст");
            return;
        }
        Defect defect;
        System.out.println("Введите id дефекта");
        int defectToChange;
        while (true) {
            defectToChange = scanInt();
            if (!repository.containsId(defectToChange)) {
                System.out.println("Дефект с таким id отсутствует");
            } else break;
        }
        defect = repository.getDefect(defectToChange);

        System.out.println("Текущий статус дефекта - " + defect.getStatus());
        System.out.println("Введите новый статус дефекта - Открыт, В работе, В тестировании, Переоткрыт, Дубль, Закрыт");

        defect.setStatus(getStatus());
        System.out.println("Статус дефекта изменен на - " + defect.getStatus());
        System.out.println("====================================");
    }

    public static Status getStatus() {
        while (true) {
            String newStatus = scanner.nextLine();
            if (Status.checkStatus(newStatus)) {
                return Status.fromString(newStatus);
            } else {
                System.out.println("Введите значение из списка");
            }
        }
    }

    public static int scanInt() {
        int count = scanner.nextInt();
        scanner.nextLine();
        return count;
    }
}
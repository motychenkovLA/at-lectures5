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
                    "- Выйти из программы (введите quit)");
            String result = scanner.nextLine();

            switch (result) {
                case "add":
                    add();
                    break;
                case "list":
                    list();
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

        System.out.println("Введите критичность дефекта - низкий, средний, высокий, блокер");
        String critical = scanner.nextLine();

        System.out.println("Введите ожидаемо количество дней на исправление:");
        int countDays = scanner.nextInt();
        scanner.nextLine();

        Attachment attachment = addAttachment();

        Defect defect = new Defect(resume, critical, countDays, attachment);
        repository.add(defect);

        System.out.println("===================================");
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
                    String defectLink = scanner.nextLine();
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
            System.out.println(def.getDisplayInf());
        }
        System.out.println("===================================");
    }
}
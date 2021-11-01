package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final int NUM_OF_BUGS = 3;

        Repository repository = new Repository(NUM_OF_BUGS);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("\n---Меню---");
            System.out.println("Добавить дефект: add");
            System.out.println("Вывести список дефектов: list");
            System.out.println("Изменить статус дефекта: change");
            System.out.println("Выйти: exit");

            System.out.print("Введите команду: ");

            String action = scanner.nextLine();

            switch (action) {
                case "add":
                    commandAddBug(repository, scanner);
                    break;
                case "list":
                    commandBugsList(repository);
                    break;
                case "exit":
                    loop = false;
                    break;
                case "change":
                    commandChangePriority(repository, scanner);
                    break;
                default:
                    System.out.println("Ошибка: такой команды нет");
                    break;
            }
        }
    }

    public static void commandAddBug(Repository repository, Scanner scanner) {
        if (!repository.isFull()) {

            System.out.println("\nДобавление дефекта");
            System.out.print("Введите резюме дефекта: ");
            String summary = scanner.nextLine();


            System.out.print("Введите количество дней на исправление дефекта: ");
            int daysToFix = inputNum(scanner);

            Priority priority = addPriority(scanner);
            Attachment attachment = addAttachment(scanner);

            Defect bug = new Defect(summary, priority, daysToFix, attachment);
            repository.addBug(bug);

        } else {
            System.out.println("Ошибка: список полный, нельзя добавить дефект");
        }
    }

    public static Attachment addAttachment(Scanner scanner) {
        while (true) {
            System.out.print("Введите тип вложения: comment, defect: ");
            String attachmentType = scanner.nextLine();

            if (attachmentType.equals("comment")) {
                System.out.print("Введите комментарий: ");
                String comment = scanner.nextLine();
                return new CommentAttachment(comment);
            }
            if (attachmentType.equals("defect")) {
                System.out.print("Введите номер дефекта: ");
                long bugId = inputNum(scanner);
                return new DefectAttachment(bugId);
            }
            System.out.println("Ошибка: такого типа вложения нет");
        }
    }

    public static Priority addPriority(Scanner scanner) {
        while (true) {
            System.out.print("Введите критичность дефекта: Блокирующий, Высокий, Средний, Низкий: ");
            String priority = scanner.nextLine();
            // todo 3 - аналогично как для Status, само распознавание Priority по читабельному имени лучше вынести в Priority
            if (Priority.getPriorityByRuName(priority) != null) {
                return Priority.getPriorityByRuName(priority);
            }
            System.out.println("Ошибка: некорретная критичность");
        }
    }

    public static int inputNum(Scanner scanner) {
        int num = scanner.nextInt();
        scanner.nextLine();
        return num;
    }

    public static void commandBugsList(Repository repository) {
        if (repository.isEmpty()) {
            System.out.println("Ошибка: список дефектов пуст");
            return;
        }

        System.out.println("\nСписок дефектов");
        for (Defect bug : repository.getAll()) {
            System.out.println(bug.toString());
        }
    }

    public static void commandChangePriority(Repository repository, Scanner scanner) {
        if (repository.isEmpty()) {
            System.out.println("Ошибка: список дефектов пуст");
            return;
        }

        System.out.print("Введите номер дефекта: ");
        int index = inputNum(scanner);
        if (repository.getElementByIndex(index) == null) {
            System.out.println("Ошибка: ошибка такого дефекта нет");
            return;
        }

        System.out.print("Введите новый статус: Открыт, Анализ, Исправление, Тестирование, Закрыт, Отклонен: ");
        String status = scanner.nextLine();
        if (Status.getStatusByRuName(status) == null) {
            System.out.println("Ошибка: ошибка такого статуса нет");
            return;
        }
        repository.getElementByIndex(index).setStatus(Status.getStatusByRuName(status));
    }
}



package tracker;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final int NUM_OF_BUGS = 3;

        Repository repository = new Repository(NUM_OF_BUGS);

        try (Scanner scanner = new Scanner(System.in)) {
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
    }

    public static void commandAddBug(Repository repository, Scanner scanner) {
        // todo 1 - if (repo.isFull()) { ошибка; return; } весь остальной код вне блока
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
            String ruNamePriority = scanner.nextLine();
            Priority priority = Priority.getPriorityByRuName(ruNamePriority);
            if (priority != null) {
                return priority;
            }
            System.out.println("Ошибка: некорретная критичность");
        }
    }

    public static int inputNum(Scanner scanner) {
        while (true){
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число");
            }
        }
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
        int id = inputNum(scanner);
        Defect bug = repository.getElementById(id);
        if (bug == null) {
            System.out.println("Ошибка: такого дефекта нет");
            return;
        }

        System.out.print("Введите новый статус: Открыт, Анализ, Исправление, Тестирование, Закрыт, Отклонен: ");
        String ruNameStatus = scanner.nextLine();

        Status status = Status.getStatusByRuName(ruNameStatus);
        if (status == null) {
            System.out.println("Ошибка: такого статуса нет");
            return;
        }
        bug.setStatus(status);
    }
}



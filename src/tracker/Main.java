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
                default:
                    System.out.println("Ошибка: такой команды нет");
                    break;
            }
        }
    }

    public static void commandAddBug(Repository repository, Scanner scanner) {
        // todo 3 - создается ещё один сканнер

        if (!repository.isFull()) {

            System.out.println("\nДобавление дефекта");
            System.out.print("Введите резюме дефекта: ");
            String summary = scanner.nextLine();

            System.out.print("Введите критичность дефекта: блокирующий, высокий, средний, низкий: ");
            String priority = scanner.nextLine();

            System.out.print("Введите количество дней на исправление дефекта: ");
            // todo 1 - scanner.nextInt() + scanner.nextLine() можно в отдельный метод вынести,
            //   чтоб каждый раз не писать и не забыть где-нибудь
            int daysToFix = inputNum(scanner);

            Attachment attachment = addAttachment(scanner);

            Defect bug = new Defect(summary, priority, daysToFix, attachment);
            repository.addBug(bug);

        } else {
            System.out.println("Ошибка: список полный, нельзя добавить дефект");
        }
    }

    public static Attachment addAttachment(Scanner scanner) {
        // todo 1 - в принципе эта переменная не нужна, можно сразу return
        // todo 3 - ещё один дубль сканера

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

    public static int inputNum(Scanner scanner){
        int num = scanner.nextInt();
        scanner.nextLine();
        return num;
    }

    public static void commandBugsList(Repository repository) {
        // todo 1 - if (isEmpty) { вывести сообщение; return; } остальной метод вне else без скобок
        if (repository.isEmpty()) {
            System.out.println("Ошибка: список дефектов пуст");
            return;
        }

        System.out.println("\nСписок дефектов");
        for (Defect bug : repository.getAll()) {
            System.out.println(bug.toString());
        }
    }
}



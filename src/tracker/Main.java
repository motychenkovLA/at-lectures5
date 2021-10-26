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
                    commandAddBug(repository);
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

    public static void commandAddBug(Repository repository) {
        Scanner scanner = new Scanner(System.in);

        if (!repository.isFull()) {

            System.out.println("\nДобавление дефекта");
            System.out.print("Введите резюме дефекта: ");
            String summary = scanner.nextLine();

            System.out.print("Введите критичность дефекта: блокирующий, высокий, средний, низкий: ");
            String priority = scanner.nextLine();

            System.out.print("Введите количество дней на исправление дефекта: ");
            int daysToFix = scanner.nextInt();
            scanner.nextLine();


            // todo 3 - для пустого вложения лучше
            //   либо (простой вариант) использовать null,
            //   либо (более сложный вариант) вынести ввод вложения в отдельный метод с циклом,
            //   чтобы просил нормально ввести дефект пока у пользователя не получится
            Attachment attachment = addAttachment();

            Defect bug = new Defect(summary, priority, daysToFix, attachment);
            repository.addBug(bug);

        } else {
            System.out.println("Ошибка: список полный, нельзя добавить дефект");
        }
    }

    public static Attachment addAttachment() {
        Attachment attachment;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите тип вложения: comment, defect: ");
            String attachmentType = scanner.nextLine();

            if (attachmentType.equals("comment")) {
                System.out.print("Введите комментарий: ");
                String comment = scanner.nextLine();
                attachment = new CommentAttachment(comment);
                return attachment;
            }
            if (attachmentType.equals("defect")) {
                System.out.print("Введите номер дефекта: ");
                long bugId = scanner.nextInt();
                scanner.nextLine();
                attachment = new DefectAttachment(bugId);
                return attachment;
            }
            System.out.println("Ошибка: такого типа вложения нет");
        }
    }

    public static void commandBugsList(Repository repository) {
        if (!repository.isEmpty()) {
            System.out.println("\nСписок дефектов");
            for (Defect bug : repository.getAll()) {
                System.out.println(bug.toString());
            }
        } else {
            System.out.println("Ошибка: список дефектов пуст");
        }
    }
}



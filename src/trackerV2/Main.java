package trackerV2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Repository repository = new Repository();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Введите название необходимой опции:\n" + "Add\n" + "List\n" + "Change\n" + "Quit");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "Add":
                        AddingBug(repository, scanner);
                        break;
                    case "List":
                        bugsList(repository);
                        break;
                    case "Quit":
                        scanner.close();
                        System.exit(0);
                        break;
                    case "Change":
                        changeStatus(repository, scanner);
                        break;
                }
            }
        }
    }
    public static void AddingBug(Repository repository, Scanner scanner) {

            System.out.print("Введите резюме дефекта: ");
            String resume = scanner.nextLine();
            System.out.print("Введите кол-во дней на исправление дефекта: ");
            int daysToFix = inputNum(scanner);
            Priority priority = addPriority(scanner);
            Attachment attachment = addAttachment(scanner);
            Defect bug = new Defect(resume, priority, daysToFix, attachment);
            repository.addBug(bug);
        System.out.println(bug.getStatus());
        }

    public static Attachment addAttachment(Scanner scanner) {
        while (true) {
            System.out.print("Выберите тип вложения (Link/Comment): ");
            String attachmentType = scanner.nextLine();
            if (attachmentType.equals("Comment")) {
                System.out.print("Добавьте комментарий: ");
                String comment = scanner.nextLine();
                return new CommentAttachment(comment);
            }
            if (attachmentType.equals("Link")) {
                System.out.print("Добавьте ссылку дефекта: ");
                long bugId = inputNum(scanner);
                return new DefectAttachment(bugId);
            }
        }
    }
    public static Priority addPriority(Scanner scanner) {
        while (true) {
            System.out.print("Выберите тип вложения (Блокирующий, Высокий, Средний, Низкий): ");
            String namePriority = scanner.nextLine();
            Priority priority = Priority.getPriorityByName(namePriority);
            if (priority != null) {
                return priority;
            }
        }
    }
    public static int inputNum(Scanner scanner) {

        while (true){
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: необходимо ввести число!");
            }
        }
    }



    public static void bugsList(Repository repository) {
        System.out.println("\nСписок дефектов:");
        for (Defect bug : repository.getDefects()) {
            System.out.println(bug.toString());
        }
    }
    public static void changeStatus(Repository repository, Scanner scanner) {
        System.out.print("Введите номер дефекта: ");
        long id = inputNum(scanner);
        Defect bug = repository.getElementById(id);
        if (bug == null) {
            System.out.println("\nУказанный дефект отсутствует.");
            return;
        }
        System.out.print("Введите новый статус: Открыт, Закрыт, Отклонен: ");
        String nameStatus = scanner.nextLine();
        Status status = Status.getStatusByName(nameStatus);
        if (status == null) {
            System.out.println("Статус отсутствует.");
            return;
        }
        if (!Transition.isAvailable(bug.getStatus(), status)){
            System.out.println("Ошибка: данная смена статуса невозможна");
            return;
        }
        bug.setStatus(status);
    }
}
package trackerV2;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        final int ARRAY_SIZE = 10;
        Repository repository = new Repository(ARRAY_SIZE);
        Scanner scanner = new Scanner(System.in);
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
                    changeSeriousness(repository, scanner);
                    break;
            }
        }
    }
    public static void AddingBug(Repository repository, Scanner scanner) {
        if (repository.isFull()) {
            System.out.println("Лимит превышен!\\n\" + \"Введите название необходимой опции:\\n\" + \"Add\\n\" + \"List\\n\" + \"Quit");

        } else {
            System.out.print("Введите резюме дефекта: ");
            String resume = scanner.nextLine();
            System.out.print("Введите кол-во дней на исправление дефекта: ");
            int daysToFix = inputNum(scanner);
            Seriousness seriousness = addSeriousness(scanner);
            Attachment attachment = addAttachment(scanner);
            Defect bug = new Defect(resume, seriousness, daysToFix, attachment);
            repository.addBug(bug);

        }
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
    public static Seriousness addSeriousness(Scanner scanner) {
        while (true) {
            System.out.print("Выберите тип вложения (Блокирующий, Высокий, Средний, Низкий): ");
            String nameSeriousness = scanner.nextLine();
            Seriousness seriousness = Seriousness.getSeriousnessByRuName(nameSeriousness);
            if (seriousness != null) {
                return seriousness;
            }
        }
    }
    public static int inputNum(Scanner scanner) {
        int num = scanner.nextInt();
        scanner.nextLine();
        return num;
    }
    public static void bugsList(Repository repository) {
        System.out.println("\nСписок дефектов:");
        for (Defect bug : repository.getDefects()) {
            System.out.println(bug.toString());
        }
    }
    public static void changeSeriousness(Repository repository, Scanner scanner) {
        System.out.print("Введите номер дефекта: ");
        int id = inputNum(scanner);
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
        bug.setStatus(status);
    }
}
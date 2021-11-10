
package trackerV2;

import java.util.Scanner;

public class Main {
    static final int AMOUNT_BUGS = 10;
    static Repository repository = new Repository(AMOUNT_BUGS);
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Введите название необходимой опции:\n" + "Add\n" + "List\n" + "Quit");
        String option = scanner.nextLine();

        while (!"Quit".equals(option)) {

            switch (option) {
                case "Add":
                    add();
                    System.out.println("Введите название необходимой опции:\n" + "Add\n" + "List\n" + "Quit");
                    option = scanner.nextLine();
                    break;
                case "List":
                    list();
                    System.out.println("Введите название необходимой опции:\n" + "Add\n" + "List\n" + "Quit");
                    option = scanner.nextLine();
                    break;
            }
        }
    }

    public static void add() {

        System.out.println("Введите резюме дефекта:");
        String resume = scanner.nextLine();
        System.out.println("Введите серьезность дефекта:\n" + " - Критичный\n" + " - Высокий\n" + " - Средний\n" + " - Низкий");
        String seriousness = scanner.nextLine();
        System.out.println("Введите кол-во дней на исправление дефекта:");
        int days = scanner.nextInt();
        scanner.nextLine();
        Attachment attachment = addAttachment();
        Defect bug = new Defect(resume, seriousness, days, attachment);
        repository.addBug(bug);


    }

    public static Attachment addAttachment() {
        System.out.println("Выберите тип вложения (Link/Comment):");

        while (true) {

            String attachmentType = scanner.nextLine();
            switch (attachmentType) {
                case ("Comment"):
                    System.out.println("Добавьте комментарий:");
                    String comment = scanner.nextLine();
                    return new CommentAttachment(comment);
                case ("Link"):
                    System.out.println("Добавьте ссылку:");
                    int link = Scan();
                    return new DefectAttachment(link);
            }
        }
    }

    public static int Scan() {
        int count = scanner.nextInt();
        scanner.nextLine();
        return count;
    }

    public static void list() {

        System.out.println("\nСписок дефектов: ");
        for (Defect bug : repository.getBugs()) {
            System.out.println(bug.toString());
        }

    }
}

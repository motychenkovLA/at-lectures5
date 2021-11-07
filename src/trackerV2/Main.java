package trackerV2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int AMOUNT_BUGS = 10;
        Repository repository = new Repository(AMOUNT_BUGS);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название необходимой опции:\n" + "Add\n" + "List\n" + "Quit");
        String option = scanner.nextLine();

        while (!"Quit".equals(option)) {

            switch (option) {
                case "Add":
                    if (!repository.isFull()) {

                        System.out.println("Введите резюме дефекта:");
                        String resume = scanner.nextLine();
                        System.out.println("Введите серьезность дефекта:\n" + " - Критичный\n" + " - Высокий\n" + " - Средний\n" + " - Низкий");
                        String seriousness = scanner.nextLine();
                        System.out.println("Введите кол-во дней на исправление дефекта:");
                        int days = scanner.nextInt();
                        scanner.nextLine();
                        Defect bug = new Defect(resume, seriousness, days);
                        repository.addBug(bug);

                        System.out.println("Введите название необходимой опции:\n" + "Add\n" + "List\n" + "Quit");
                        option = scanner.nextLine();
                    } else {
                        System.out.println("Лимит превышен!\n" + "Введите название необходимой опции:\n" + "Add\n" + "List\n" + "Quit");
                        option = scanner.nextLine();
                    }
                    break;
                case "List":
                    if (!repository.isEmpty()) {

                        System.out.println("Список дефектов: ");
                        for (Defect bug : repository.getBugs()) {
                            System.out.println(bug.BugInfo());
                        }
                        System.out.println("\nВведите название необходимой опции:\n" + "Add\n" + "List\n" + "Quit");
                        option = scanner.nextLine();
                        break;

                    }

            }
        }

    }
}

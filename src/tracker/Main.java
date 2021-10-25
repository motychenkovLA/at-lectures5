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
                    // todo 3 - какая разница сколько дефектов насчитал дефект, если нас интересует заполненность репо
                    // todo 3 - за проверку заполненности репо должен отвечать репо, а не мейн
                    if (repository.getAvailabilityAddBug()) {

                        System.out.println("\nДобавление дефекта");
                        System.out.print("Введите резюме дефекта: ");
                        String summary = scanner.nextLine();

                        System.out.print("Введите критичность дефекта: блокирующий, высокий, средний, низкий: ");
                        String priority = scanner.nextLine();

                        System.out.print("Введите количество дней на исправление дефекта: ");
                        int daysToFix = scanner.nextInt();
                        scanner.nextLine();

                        Defect bug = new Defect(summary, priority, daysToFix);
                        repository.addBug(bug);

                    } else {
                        System.out.println("Ошибка: список полный, нельзя добавить дефект");
                    }
                    break;
                case "list":
                    // todo 3 - аналогично add
                    if (!repository.isEmpty()) {

                        // todo 3 - clone?
                        Defect[] bugs = repository.getAll();

                        System.out.println("\nСписок дефектов");
                        // todo 1 - for-each
                        for (Defect bug : bugs) {
                            System.out.println(bug.getBugInfo());
                        }

                    } else {
                        System.out.println("Ошибка: список дефектов пуст");
                    }
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
}

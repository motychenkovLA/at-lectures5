package trackerV2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int ARRAY_SIZE = 10;
        Defect[] list = new Defect[ARRAY_SIZE];
        int i = 0;
        int a = 0;


        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название необходимой опции:\n" + "Add\n" + "List\n" + "Quit");
        String option = scanner.nextLine();

        while (!"Quit".equals(option)) {

            switch (option) {
                case "Add":
                    if (i != ARRAY_SIZE) {

                        System.out.println("Введите резюме дефекта:");
                        String resume = scanner.nextLine();
                        System.out.println("Введите серьезность дефекта:\n" + " - Критичный\n" + " - Высокий\n" + " - Средний\n" + " - Низкий");
                        String seriousness = scanner.nextLine();
                        System.out.println("Введите кол-во дней на исправление дефекта:");
                        int days = scanner.nextInt();
                        scanner.nextLine();
                        Defect bug = new Defect(i, resume, seriousness, days);
                        list[i] = bug;
                        i++;
                        System.out.println("Введите название необходимой опции:\n" + "Add\n" + "List\n" + "Quit");
                        option = scanner.nextLine();
                    } else {
                        System.out.println("Лимит превышен!\n" + "Введите название необходимой опции:\n" + "Add\n" + "List\n" + "Quit");
                        option = scanner.nextLine();
                    }
                    break;
                case "List":
                    while (a != i) {
                        System.out.println(list[a].Bug());
                        a++;
                    }
                    System.out.println("\nВведите название необходимой опции:\n" + "Add\n" + "List\n" + "Quit");
                    option = scanner.nextLine();
                    break;

            }

        }
    }

}

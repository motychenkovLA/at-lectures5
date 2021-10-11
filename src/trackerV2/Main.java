package trackerV2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int ARRAY_SIZE = 10;
        String[] list = new String[ARRAY_SIZE];
        int i = 0;
        int a = 0;


        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название необходимой опции:\n" + "Add\n" + "List\n" + "Quit");
        String option = scanner.nextLine();

        while (!"Quit".equals(option)) {

            switch (option) {
                case "Add":
                    if (i != 10) {

                        System.out.println("Введите резюме дефекта:");
                        String summary = scanner.nextLine();
                        System.out.println("Введите критичность дефекта:\n" + " - Критичный\n" + " - Высокий\n" + " - Средний\n" + " - Низкий");
                        String criticality = scanner.nextLine();
                        System.out.println("Введите кол-во дней на исправление дефекта:");
                        int days = scanner.nextInt();
                        scanner.nextLine();
                        String output = String.join(" ", "\nРезюме дефекта: " + summary + "\n" + "Критичность дефекта: " + criticality + "\n" + "Кол-во дней на исправление: " + days + "\n");
                        list[i] = output;
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
                        System.out.println("Номер: " + a + list[a]);
                        a++;
                    }
                    System.out.println("\nВведите название необходимой опции:\n" + "Add\n" + "List\n" + "Quit");
                    option = scanner.nextLine();
                    break;

            }

        }
    }

}
package trackerV2;

import java.util.Scanner;

public class Main {
    static final int ARRAY_SIZE = 10;
    static Defect[] bugs = new Defect[ARRAY_SIZE];
    static int counter = 0;
    static int counterList = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        while (true) {
            System.out.println("Введите название необходимой опции:\n" + "Add\n" + "List\n" + "Quit");
            String choice = scanner.nextLine();
            switch (choice) {
                case "Add":
                    add();
                    break;
                case "List":
                    list();
                    break;
                case "Quit":
                    scanner.close();
                    System.exit(0);
                    break;
            }
        }
    }

    public static void add() {

        if (counter >= ARRAY_SIZE) {
            System.out.println("Лимит превышен!\n" + "Введите название необходимой опции:\n" + "Add\n" + "List\n" + "Quit");

        }

        System.out.println("Введите резюме дефекта:");
        String resume = scanner.nextLine();
        System.out.println("Введите серьезность дефекта:\n" + " - Критичный\n" + " - Высокий\n" + " - Средний\n" + " - Низкий");
        String seriousness = scanner.nextLine();
        System.out.println("Введите кол-во дней на исправление дефекта:");
        int days = scanner.nextInt();
        scanner.nextLine();
        Defect bug = new Defect(counter, resume, seriousness, days);
        bugs[counter] = bug;
        counter++;


    }

    public static void list() {

        while (counterList != counter) {
            System.out.println(bugs[counterList].BugInfo());
            counterList++;
        }


    }
}


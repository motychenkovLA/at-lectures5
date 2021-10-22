package tracker;

import java.util.Scanner;

public class Main {
    static final int COUNT_OF_BUGS = 10;
    static Defect[] bugList = new Defect[COUNT_OF_BUGS];
    static long bugNumber = 0L;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println('\n' + "Выберите, что хотите сделать:\n" +
                    "- Добавить новый дефект (введите add)\n" +
                    "- Вывести список дефектов (введите list)\n" +
                    "- Выйти из программы (введите quit)");
            String result = scanner.nextLine();

            switch (result) {
                case "add":
                    add();
                    break;
                case "list":
                    list();
                    break;
                case "quit":
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println('\n' + "Введите значение из списка");
                    break;
            }
        }
    }

    public static void add() {

        if (bugNumber >= COUNT_OF_BUGS) {
            System.out.println('\n' + "Невозможно добавить больше дефектов");
            return;
        }

        System.out.println("Введите резюме дефекта:");
        String resume = scanner.nextLine();

        System.out.println("Введите критичность дефекта - низкий, средний, высокий, блокер");
        String critical = scanner.nextLine();

        System.out.println("Введите ожидаемо количество дней на исправление:");
        int countDays = scanner.nextInt();
        // todo 1 - nextLine()
        Defect defect = new Defect(bugNumber, resume, critical, countDays);

        System.out.println("===================================");

        bugList[(int) bugNumber] = defect;

        bugNumber++;

    }

    public static void list() {
        if (bugNumber == 0) {
            System.out.println("Список пуст");
            return;
        }
        for (int i = 0; i < bugNumber; i++) {
            // todo 3 - результат get выкидывается в никуда
            bugList[i].getDisplayInf();
        }
        System.out.println("===================================");
    }
}
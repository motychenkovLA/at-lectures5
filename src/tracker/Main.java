package tracker;

import java.util.Scanner;

public class Main {
    static final int COUNT_OF_BUGS = 1;
    // todo 3 - в данном случае хранится консольное представление, а не сам дефект
    //   лучше по массиву на каждое поле
    static String[] bugList = new String[COUNT_OF_BUGS];
    static int bugNumber = 0;
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
                    list(bugList);
                    break;
                case "quit":
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println('\n' + "Введите значение из списка");
            }
        }
    }

    public static void add() {

        if (bugNumber == COUNT_OF_BUGS) {
            System.out.println('\n' + "Невозможно добавить больше дефектов");
        } else {
            System.out.println("Введите резюме дефекта:");
            String resume = scanner.nextLine();

            System.out.println("Введите критичность дефекта - низкий, средний, высокий, блокер");
            String critical = scanner.nextLine();

            System.out.println("Введите ожидаемо количество дней на исправление:");
            int countDays = scanner.nextInt();
            bugList[bugNumber] = resume + " | " + critical + " | " + countDays + " |";
            bugNumber++;
        }
    }

    // todo 1 - принимает в аргумент местное статическое поле
    public static void list(String[] listOfBug) {
        // todo 3 - перебирается весь массив вместо заполненной части
        for (int i = 0; i < COUNT_OF_BUGS; i++) {
            if (listOfBug[i] != null) {
                System.out.println(i + ". " + listOfBug[i]);
            }
        }
    }
}
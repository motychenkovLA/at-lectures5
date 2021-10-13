package tracker;

import java.util.Scanner;

public class Main {
    static final int COUNT_OF_BUGS = 10;
    // todo 3 - в данном случае хранится консольное представление, а не сам дефект
    //   лучше по массиву на каждое поле
    static String[] bugList = new String[COUNT_OF_BUGS];
    static int bugNumber = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println('\n' + "Выберите, что хотите сделать:\n" +
                    "- Добавить новый дефект (введите add)\n" +
                    "- Вывести список дефектов (введите list)\n" +
                    "- Выйти из программы (введите quit)");
            String result = scanner.nextLine();

            switch (result) {
                case "add":
                    // todo 1 - пользователь целиком вводит информацию о дефекте
                    //  и только после этого ему говорят, что список уже заполнен
                    String s = add();
                    addToList(s);
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
        // todo 1 - while предпочтительнее do-while
        } while (true);
    }

    public static void addToList(String str) {
        if (bugNumber == COUNT_OF_BUGS) {
            System.out.println('\n' + "Невозможно добавить больше дефектов");
        } else {
            bugList[bugNumber] = str;
            bugNumber++;
        }
    }

    public static String add() {
        // todo 1 - дублируется сканер
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите резюме дефекта:");
        String resume = scanner.nextLine();

        System.out.println("Введите критичность дефекта - низкий, средний, высокий, блокер");
        String critical = scanner.nextLine();

        System.out.println("Введите ожидаемо количество дней на исправление:");
        int countDays = scanner.nextInt();

        return (resume + " | " + critical + " | " + countDays + " |");
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
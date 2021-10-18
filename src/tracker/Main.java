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
            }
        }
    }

    public static void add() {

        if (bugNumber == COUNT_OF_BUGS) {
            System.out.println('\n' + "Невозможно добавить больше дефектов");
        } else {
            Defect defect = new Defect();

            defect.setId(bugNumber);

            System.out.println("Введите резюме дефекта:");
            defect.setResume(scanner.nextLine());

            System.out.println("Введите критичность дефекта - низкий, средний, высокий, блокер");
            defect.setCritical(scanner.nextLine());

            System.out.println("Введите ожидаемо количество дней на исправление:");
            defect.setCountDays(scanner.nextInt());
            String s = scanner.nextLine();

            System.out.println("===================================");

            bugList[(int) bugNumber]= defect;

            bugNumber++;
        }
    }

    public static void list() {
        if (bugNumber==0){
            System.out.println("Список пуст");
        } else {
            System.out.println("id|    Резюме|    Серьезность| Количество дней на исправление");
        }
        for (int i = 0; i < bugNumber; i++) {
            if (bugList[i] != null) {
                Defect def = bugList[i];
                System.out.println(def.getId() + "| " + def.getResume()
                        + "| " + def.getCritical() + "| " + def.getCountDays());
            }
        }
        System.out.println("===================================");
    }
}
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
                    // todo 3 - break;
            }
        }
    }

    public static void add() {

        // todo 0 - можно >= просто на всякий случай, чтоб уже наверняка
        if (bugNumber == COUNT_OF_BUGS) {
            System.out.println('\n' + "Невозможно добавить больше дефектов");
            // todo 1 - return; и вторую часть метода вытащить из else
        } else {
            // todo 3 - дефект заполняется не через конструктор, существует в невалидном состоянии, позволяет менять id
            Defect defect = new Defect();

            defect.setId(bugNumber);

            System.out.println("Введите резюме дефекта:");
            defect.setResume(scanner.nextLine());

            System.out.println("Введите критичность дефекта - низкий, средний, высокий, блокер");
            defect.setCritical(scanner.nextLine());

            System.out.println("Введите ожидаемо количество дней на исправление:");
            defect.setCountDays(scanner.nextInt());
            // todo 0 - зачем s ?
            String s = scanner.nextLine();

            System.out.println("===================================");

            bugList[(int) bugNumber]= defect;

            bugNumber++;
        }
    }

    public static void list() {
        if (bugNumber==0){
            System.out.println("Список пуст");
            // todo 1 - return, убрать else
        } else {
            // todo 1 - форматирование заголовка пробелами смысла особо не несет, все равно разъедется
            //   можно просто выводить дефект "карточкой" построчно примерно так:
            //     Id: 0
            //     Резюме: Что-то сломалось
            //     Серьезность: Блокер
            //     Дней на исправление: 3
            //     ===== ===== =====
            System.out.println("id|    Резюме|    Серьезность| Количество дней на исправление");
        }
        for (int i = 0; i < bugNumber; i++) {
            // todo 1 - если дефекты кладутся последовательно вплоть до bugNumber, смысла проверять на null нет,
            //   они никогда не будут null
            if (bugList[i] != null) {
                Defect def = bugList[i];
                // todo 3 - строковое представление должен собирать сам Defect, например методом getDisplayInfo
                System.out.println(def.getId() + "| " + def.getResume()
                        + "| " + def.getCritical() + "| " + def.getCountDays());
            }
        }
        System.out.println("===================================");
    }
}
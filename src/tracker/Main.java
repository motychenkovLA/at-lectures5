package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // + предложить пользователю выбрать: добавить новый дефект ("add"), вывести список ("list")
//    или выйти из программы ("quit") - главное меню
// + при добавлении ввод параметров происходит как раньше
// после добавления, вернуться в главное меню
//программа максимально может хранить 10 дефектов, при попытке добавить больше, сообщает о невозможности
//      и автоматически возвращает в главное меню
//при выводе списка дефекты отображаются в виде "номер (начиная с 0) | резюме | серьезность |
//     количество дней на исправление"

        String menu = null;
        final int MAX_DEFECTS = 10; // Максимальное количество дефектов
        int [] defects = new int [MAX_DEFECTS]; // Объявили массив, размера 10

        for (int i=0; i<2; i++) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Выберите: (Add)/ (List)/ (Quit)");
            menu = scan.nextLine();
            switch (menu) {
                case "Add":
                    System.out.println("Введите резюме дефекта:");
                    String resumeDef = scan.nextLine();
                    System.out.println("Введите критичность дефекта (Low/ Medium/ High/ Highest/:");
                    String prioritetDef = scan.nextLine();
                    System.out.println("Введите ожидаемое количество дней на исправление:");
                    int daysToFix = scan.nextInt();
                    scan.nextLine();
                    int workWeek = 5;
                    boolean moreWorkWeek = daysToFix > workWeek;
                    System.out.println("Инфо о заведенном дефекте:");
                    System.out.println("РЕЗЮМЕ:" + resumeDef + "\n" + "СЕРЬЕЗНОСТЬ:" + prioritetDef + "\n" +
                            "КОЛИЧЕСТВО ДНЕЙ НА ИСПРАВЛЕНИЕ:" + daysToFix + "\n" + "ЗАЙМЕТ БОЛЬШЕ РАБОЧЕЙ НЕДЕЛИ:" + moreWorkWeek);
                    break;

                    case "List":

                    break;

                    case "Quit":

                    break;

                    default:
                    System.out.println("Такого пункта меню нет");
                    break;
            }


          }


    }
}


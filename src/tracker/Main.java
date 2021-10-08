package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Предложение пользователю ввести резюме дефекта, принять строку
        System.out.println("Введите резюме дефекта:");
        String resumeDef = scan.nextLine();

        // Предложение ввести критичность, выдать список и принять строку
        System.out.println("Введите критичность дефекта (Low/ Medium/ High/ Highest/:");
        String prioritetDef = scan.nextLine();

        // Предложение ввести ожидаемое количество дней на исправление и принять число
        System.out.println("Введите ожидаемое количество дней на исправление:");
        int daysToFix = scan.nextInt();
        scan.nextLine();

        // Вывести инфо о заведенном дефекте
//        todo "5" так называемое магическое число, что оно значит, почему тут 5 а не 20? не понятно.
//         Необходимо вынести в константу с осмысленным именем
        int workWeek = 5;
        boolean moreWorkWeek = daysToFix > workWeek;
        System.out.println("Инфо о заведенном дефекте:");
//        todo вот за эту линию стараемся не заезжать, необходимо переносить длинные строки --------------------------->
        System.out.println("РЕЗЮМЕ:" + resumeDef + "\n" + "СЕРЬЕЗНОСТЬ:" + prioritetDef + "\n" +
                "КОЛИЧЕСТВО ДНЕЙ НА ИСПРАВЛЕНИЕ:" + daysToFix + "\n" + "ЗАЙМЕТ БОЛЬШЕ РАБОЧЕЙ НЕДЕЛИ:" + moreWorkWeek);

    }
}

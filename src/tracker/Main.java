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
        boolean moreWorkWeek = daysToFix > 5;
        System.out.println("Инфо о заведенном дефекте:");
        System.out.println("РЕЗЮМЕ:" + resumeDef + "\n" + "СЕРЬЕЗНОСТЬ:" + prioritetDef + "\n" + "КОЛИЧЕСТВО ДНЕЙ НА ИСПРАВЛЕНИЕ:" + daysToFix + "\n" + "ЗАЙМЕТ БОЛЬШЕ РАБОЧЕЙ НЕДЕЛИ:" + moreWorkWeek);

    }
}

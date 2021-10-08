package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] listBug = new String[10];

        int countReq =  0; // переменная для количества дефектов
        for (int i = 0; i < 12; i++) {

            Scanner scanner = new Scanner(System.in);


            System.out.println(" Выберите действие Add (Новый дефект)" +
                    " List (Вывести список дефектов)" +

                    " Quit (Вернуться в главное меню)");
            String action = scanner.nextLine();

            switch (action) {
                case "Add":

                    if (countReq > 9) {
                        System.out.println("Невозможно добавить больше 10 дефектов");

                        break;
                    }
                    System.out.println("Введите резюме дефекта:");
                    String resume = scanner.nextLine();

                    System.out.println("Введите критичность дефекта (Высокий, Средний, Низкий ):");
                    String priority = scanner.nextLine();

                    System.out.println("Введите ожидаемое количество дней на исправление дефекта:");
                    int daysToFixed = scanner.nextInt();
                    scanner.nextLine();
                    String infoBug = "|"+ countReq + "|"+ resume + "|"+ priority+ "|" + daysToFixed+ "|" ;
                    listBug[countReq]=infoBug;
                    countReq = countReq + 1;
                    break;
                case "List":
                  // System.out.println(Arrays.toString(listbug));

                    for (String a: listBug) {
                        System.out.println(a);
                    }
                    break;

                case "Quit":
                    break;
                default:
                    System.out.println("Операция не существует");
                    break;
            }


            //final int WORK_DAYS = 5;

            //Scanner scanner = new Scanner(System.in);

            //System.out.println("Введите резюме дефекта:");
            //String resume = scanner.nextLine();

            //System.out.println("Введите критичность дефекта (Высокий, Средний, Низкий ):");
            //String priority = scanner.nextLine();

            //System.out.println("Введите ожидаемое количество дней на исправление дефекта:");
            //int daysToFixed = scanner.nextInt();
            //scanner.nextLine();

            //boolean moreThanWeek = WORK_DAYS < daysToFixed;

            // System.out.println("Информация о дефекте:");
            //System.out.println( "Резюме:" +  resume + "|Серьезность:" + priority + "|Количество дней на исправление:"
            //+ daysToFixed + "|Займет больше рабочей недели? " + moreThanWeek + "|" );
        }
    }
}

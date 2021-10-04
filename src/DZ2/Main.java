package DZ2;

import java.util.Scanner;

public class Main {
        public static void main(String[] args) {

            String resum;
            String crit;
            int days;
            int weekDays = 5;
            char ent = '\n';
            boolean result;

            System.out.println("Введите резюме дефекта:");
            Scanner scanner = new Scanner(System.in);
            resum = scanner.nextLine();
            System.out.println("Укажите критичность дефекта" + ent + "Высокий" + ent + "Средний" + ent +"Низкий");
            crit = scanner.nextLine();
            System.out.println("Укажите ожидаемое количество дней на исправление дефекта");
            days = scanner.nextInt();
            result = days > weekDays;
            System.out.println("РЕЗЮМЕ: " + resum + ent + "КРИТИЧНОСТЬ: " + crit + ent + "ВРЕМЯ ИСПРАВЛЕНИЯ: " + days + ent + "БОЛЬШЕ РАБОЧЕЙ НЕДЕЛИ? " + result);

        }
    }

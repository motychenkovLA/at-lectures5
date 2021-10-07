package DZ2;
// todo 1 пакет в tracker переименовать

import java.util.Scanner;

public class Main {
    // todo 0 - отступ на 8 символов вместо 4
        public static void main(String[] args) {

            // todo 1 - объявление переменных задолго до использования, без инициализации
            String resum; // todo 0 -> resume, нет смысла экономить одну букву
            String crit; // todo 0 -> severity / priority
            int days;
            int weekDays = 5; // todo 1 - константы final, CAPS_WITH_UNDERSCORES
            char ent = '\n'; // todo 1 - нет смысла выносить 1 символ в константу, писать каждый раз " + ent + " длиннее чем \n
            boolean result; // todo 0 - это не результат, это "более чем неделя" (например moreThanWeek)

            System.out.println("Введите резюме дефекта:");
            Scanner scanner = new Scanner(System.in);
            resum = scanner.nextLine();
            System.out.println("Укажите критичность дефекта" + ent + "Высокий" + ent + "Средний" + ent +"Низкий");
            crit = scanner.nextLine();
            System.out.println("Укажите ожидаемое количество дней на исправление дефекта");
            days = scanner.nextInt(); // todo 3 - не переносится ввод после чтения числа, nextString()
            result = days > weekDays;
            System.out.println("РЕЗЮМЕ: " + resum + ent + "КРИТИЧНОСТЬ: " + crit + ent + "ВРЕМЯ ИСПРАВЛЕНИЯ: " + days + ent + "БОЛЬШЕ РАБОЧЕЙ НЕДЕЛИ? " + result);

        }
    } // todo 0 - отступ закрытой скобки не соответствует отступу открытой скобки

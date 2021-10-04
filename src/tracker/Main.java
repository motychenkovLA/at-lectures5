package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите резюме дефекта:");
        String resume = scanner.nextLine();

        System.out.println("Введите критичность дефекта - низкий, средний, высокий, блокер");
        String critical = scanner.nextLine();

        System.out.println("Введите ожидаемо количество дней на исправление:");
        int countDays = scanner.nextInt();
        String s = scanner.nextLine();

        scanner.close();

        boolean howMuchTime = countDays > 7;

        System.out.format("%32s%13s%32s%31s", "Резюме|", "Серьёзность|",
                "Количество дней на исправление|", "Займет больше рабочей недели?" + '\n');
        System.out.format("%32s%13s%32s%31s", resume + "|", critical + "|", countDays + "|", howMuchTime);

    }
}
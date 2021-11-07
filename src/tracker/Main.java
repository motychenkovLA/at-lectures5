package tracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final int WORKING_WEEK = 5;

        Scanner data_bug = new Scanner(System.in);

        System.out.print("Введите резюме дефекта: ");
        String resume_bug = data_bug.nextLine();

        System.out.print("Введите критичность дефекта одним значением (Низкий, Средний, Высокий, Блокирующий): ");
        String criticality_bug = data_bug.next();

        System.out.print("Введите количество дней для исправления дефекта в числовом формате: ");
        int days_fix_bug = data_bug.nextInt();

        boolean comp_days_bug = days_fix_bug > WORKING_WEEK;

        String generalInfo_bug = resume_bug + " | " + criticality_bug + " | " + days_fix_bug + " | " + "Займет больше одной недели:" + "(" + comp_days_bug + ")";
        System.out.println("Общая информация по дефекту: " + generalInfo_bug);
    }
}

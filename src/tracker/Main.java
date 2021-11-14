package tracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final int BUG_QUANTITY = 10;

        boolean bug_tracker_launched = true;

        int base_bug_quantity = 0;

        Defect[] defects = new Defect[BUG_QUANTITY];

        Scanner base_bug = new Scanner(System.in);

        while (bug_tracker_launched) {

            System.out.println("Меню баг-трекинговой системы:"
                    + System.lineSeparator() + "1. Add"
                    + System.lineSeparator() + "2. List"
                    + System.lineSeparator() + "3. Quit");

            System.out.print("Введите цифровой номер требуемого пункта: ");

            int bug_menu_num = base_bug.nextInt();

            switch (bug_menu_num) {

                case 1: {

                    if (base_bug_quantity < BUG_QUANTITY) {

                        base_bug.nextLine();

                        System.out.print("Введите резюме дефекта: ");
                        String bug_resume = base_bug.nextLine();

                        System.out.print("Введите критичность дефекта одним значением (Низкий, Средний, Высокий, Блокирующий): ");
                        String bug_criticality = base_bug.next();

                        System.out.print("Введите количество дней для исправления дефекта в числовом формате: ");
                        int bug_fix_days = base_bug.nextInt();

                        //solid_bug_resume[base_bug_quantity] = bug_resume;

                        defects[base_bug_quantity] = new Defect(base_bug_quantity);

                        defects[base_bug_quantity].setResume(bug_resume);

                        //solid_bug_criticality[base_bug_quantity] = bug_criticality;
                        defects[base_bug_quantity].setCriticality(bug_criticality);

                        //solid_bug_fix_days[base_bug_quantity] = bug_fix_days;
                        defects[base_bug_quantity].setBug_fix_days(bug_fix_days);

                        base_bug_quantity++;

                    } else {

                        System.out.println("Достигнуто максимальное значение заведенных дефектов кратное: " + "(" + BUG_QUANTITY + ")");
                    }
                }
                break;

                case 2: {

                    /*if (base_bug_quantity > 0) {

                        for (int i = 0; i < base_bug_quantity; i++) {

                            System.out.println("Номер дефекта: " + i + " | "
                                    + "Резюме дефекта: " + solid_bug_resume[i] + " | "
                                    + "Приоритет дефекта: " + solid_bug_criticality[i] + " | "
                                    + "Колличетсво дней на исправление дефекта: " + solid_bug_fix_days[i]);
                        }*/

                    if (base_bug_quantity > 0) {

                        for (int i = 0; i < base_bug_quantity; i++) {

                                System.out.println(defects[i].getDefect());

                        }

                    } else {

                        System.out.println("ПУСТО");

                    }
                }
                break;

                case 3: {

                    System.out.println("Завершение работы баг-трегинговой системы");

                    bug_tracker_launched = false;
                }
                default: {

                    System.out.println("Не корректное значение пункта! Введите номер пункта согласно меню!");

                }
            }
        }
    }
}

package tracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final int BUG_QUANTITY = 10;

        boolean bug_tracker_launched = true;

        int base_bug_quantity = 0;

        Repository repository = new Repository(BUG_QUANTITY);

        Scanner base_bug = new Scanner(System.in);

        while (bug_tracker_launched) {

            System.out.println("Меню баг-трекинговой системы:"
                    + System.lineSeparator() + "1. Add"
                    + System.lineSeparator() + "2. List"
                    + System.lineSeparator() + "3. Change"
                    + System.lineSeparator() + "4. Quit");

            System.out.print("Введите цифровой номер требуемого пункта: ");

            int bug_menu_num = base_bug.nextInt();

            switch (bug_menu_num) {

                case 1: {

                    if (base_bug_quantity < BUG_QUANTITY) {

                        base_bug.nextLine();

                        System.out.print("Введите резюме дефекта: ");
                        String bug_resume = base_bug.nextLine();

                        System.out.print("Выберите критичность дефекта:"
                                + System.lineSeparator() + "1. Blocker"
                                + System.lineSeparator() + "2. Critical"
                                + System.lineSeparator() + "3. Major"
                                + System.lineSeparator() + "4. Minor"
                                + System.lineSeparator() + "Введите номер подпункта: ");
                        DefectSeverity defectSeverity = DefectSeverity.Default;
                        int defectSeverityInputDate = base_bug.nextInt();

                        switch (defectSeverityInputDate) {
                            case 1: {
                                defectSeverity = DefectSeverity.Blocker;
                            }
                            break;
                            case 2: {
                                defectSeverity = DefectSeverity.Critical;
                            }
                            break;
                            case 3: {
                                defectSeverity = DefectSeverity.Major;
                            }
                            break;
                            case 4: {
                                defectSeverity = DefectSeverity.Minor;
                            }
                            break;
                            default: {

                                System.out.println("Не корректное значение пункта! Введите номер под пункта согласно меню!");

                            }
                        }

                        System.out.print("Введите количество дней для исправления дефекта в числовом формате: ");
                        int bug_fix_days = base_bug.nextInt();

                        System.out.print("Выбирите тип вложения к дефекту:"
                                + System.lineSeparator() + "1. Комментарий"
                                + System.lineSeparator() + "2. Ссылка на другой дефект"
                                + System.lineSeparator() + "Введите номер подпункта: ");
                        int pointAttachment = base_bug.nextInt();

                        switch (pointAttachment) {
                            case 1: {
                                base_bug.nextLine();
                                System.out.println("Введите комментарий к дефекту: ");
                                String inputDate = base_bug.nextLine();
                                String resultDate = new CommentAttachment(inputDate).toString();
                                Defect defect = new Defect(bug_resume, defectSeverity, bug_fix_days, resultDate, DefectStatus.Open);
                                repository.add(defect);
                            }
                            break;
                            case 2: {
                                base_bug.nextLine();
                                System.out.println("Введите ID дефекта на которого вы ссылаетесь: ");
                                int inputDate = base_bug.nextInt();
                                String resultDate = new DefectAttachment(inputDate).toString();
                                Defect defect = new Defect(bug_resume, defectSeverity, bug_fix_days, resultDate, DefectStatus.Open);
                                repository.add(defect);
                            }
                            break;
                            default: {

                                System.out.println("Не корректное значение пункта! Введите номер под пункта согласно меню!");

                            }
                        }

                        base_bug_quantity++;

                    } else {

                        System.out.println("Достигнуто максимальное значение заведенных дефектов кратное: " + "(" + BUG_QUANTITY + ")");
                    }
                }
                break;

                case 2: {

                    Defect[] repositoryAllBug = repository.getAll();

                    if (repository.place()) {

                        System.out.println("ПУСТО");
                    } else {
                        for (Defect defect : repositoryAllBug) {
                            if (defect != null) {
                                System.out.println(defect.getDefectInformation());
                            }
                        }
                    }

                }
                break;

                case 3: {

                    Defect[] defects = repository.getAll();

                    System.out.println("Введите ID дефекта, за затем его статус: ");

                    int idInputDate = base_bug.nextInt();

                    for (Defect defect : defects) {
                        if (defect == null) {
                            continue;
                        } else if (defect.getId() == idInputDate) {
                            System.out.println("Выбранный дефект: ");
                            Defect selectedDefect = defect;
                            System.out.println(selectedDefect.getDefectInformation());
                            System.out.println("Выбирите новый статус дефекта:"
                                    + System.lineSeparator() + "1. Open"
                                    + System.lineSeparator() + "2. Retest"
                                    + System.lineSeparator() + "3. Fixed"
                                    + System.lineSeparator() + "4. Closed"
                                    + System.lineSeparator() + "Введите номер подпункта: ");
                            int defectStatusInputDate = base_bug.nextInt();
                            switch (defectStatusInputDate) {
                                case 1: {
                                    selectedDefect.setStatus(DefectStatus.Open);
                                    System.out.println("Статус дефекта: " + selectedDefect.getId()
                                            + "изменен на: " + selectedDefect.getStatus());
                                }
                                break;
                                case 2: {
                                    selectedDefect.setStatus(DefectStatus.Retest);
                                    System.out.println("Статус дефекта: " + selectedDefect.getId()
                                            + "изменен на: " + selectedDefect.getStatus());
                                }
                                break;
                                case 3: {
                                    selectedDefect.setStatus(DefectStatus.Fixed);
                                    System.out.println("Статус дефекта: " + selectedDefect.getId()
                                            + "изменен на: " + selectedDefect.getStatus());
                                }
                                break;
                                case 4: {
                                    selectedDefect.setStatus(DefectStatus.Closed);
                                    System.out.println("Статус дефекта: " + selectedDefect.getId()
                                            + "изменен на: " + selectedDefect.getStatus());
                                }
                                break;
                                default: {
                                    System.out.println("Не корректное значение пункта! Введите номер под пункта согласно меню!");

                                }
                            }

                        }
                    }
                }

                break;

                case 4: {

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

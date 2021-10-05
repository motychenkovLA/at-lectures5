package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Предложение пользователю ввести резюме дефекта, принять строку
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите резюме дефекта:");
        String resumeDef = scan.nextLine();

        // Предложение ввести критичность и выдать список, принять строку
        System.out.println("Введите критичность дефекта (Low/ Medium/ High/ Highest/:");
        String prioritet = scan.nextLine();
    }
}

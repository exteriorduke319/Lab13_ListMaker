import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner drake = new Scanner(System.in);
    public static ArrayList <String> strings = new ArrayList<>();

    public static void main(String[] args) {
        boolean programRun = true;
        String menuInput;
        strings.addAll(Arrays.asList("Oven", "iPad", "SuperBowlXLIII", "Roethlisberger", "Tomlin", "Cardinals", "Steelers", "2009", "Hines", "Santonio"));


        while(programRun) {
            menuInput = InputHelper.getRegExString(drake, "Options: \nA - Add an item to the list\nD - Delete an item from the list\nP - Print the list\nQ- Quit the program", "[AaDdPpQq]");

            if (menuInput.equalsIgnoreCase("a")) {
                add();
            } else if (menuInput.equalsIgnoreCase("d")) {
                delete();
            } else if (menuInput.equalsIgnoreCase("p")) {
                print();
                System.out.println();
            } else {
                if (quit()) {
                    System.out.println("Thank you shawty!");
                    programRun = false;
                }
            }
        }

    }

    public static void add() {
        strings.add(InputHelper.getNonZeroLenString(drake, "What would you like to add?"));
        System.out.println();
    }

    public static void delete() {
        print();
        strings.remove(InputHelper.getRangedInt(drake, "What index would you like to delete?", 0, strings.size()));
        System.out.println();
    }

    public static void print() {
        for (int i = 0; i < strings.size(); i++) {
            System.out.print(i + " - " + strings.get(i) + ", ");
        }
        System.out.println();
    }

    public static boolean quit() {
        return InputHelper.getYNConfirm(drake, "Are you sure you want to quit? [Y/N]");
    }
}
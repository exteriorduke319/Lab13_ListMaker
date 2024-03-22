import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.plaf.FileChooserUI;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import static java.nio.file.StandardOpenOption.CREATE;

public class Main {
    public static Scanner drake = new Scanner(System.in);
    public static ArrayList <String> strings = new ArrayList<>();
    private static boolean saved = false;
    private static boolean loaded = false;
    private static boolean edited = false;
    private static String fileName = null;

    public static void main(String[] args) throws IOException {
        boolean programRun = true;
        boolean saveCurrent = false;
        String menuInput;



        while(programRun) {
            menuInput = InputHelper.getRegExString(drake, "Options: \nA - Add an item to the list\nD - Delete an item from the list\nV - View the list\nO - Open a file from disk\nS - Save the current file to disk\nC - Clear the current list\nQ- Quit the program", "[AaDdVvOoSsCcQq]");

            if (menuInput.equalsIgnoreCase("a")) {
                add();
                if (loaded) {
                    saved = false;
                    edited = true;
                }
            } else if (menuInput.equalsIgnoreCase("d")) {
                delete();
                if (loaded) {
                    saved = false;
                    edited = true;
                }
            } else if (menuInput.equalsIgnoreCase("v")) {
                view();
            } else if (menuInput.equalsIgnoreCase("o")) {
                if (edited) {
                    if (loaded) {
                        IOHelper.writeFile(strings, fileName);
                    }
                }
                else {
                    saveCurrent = InputHelper.getYNConfirm(drake, "Do you want to save the current list before opening a new one?");
                    if (saveCurrent) {
                        IOHelper.writeFile(strings, InputHelper.getNonZeroLenString(drake, "What would you like to name the file?"));
                    }
                }

                clear();
                fileName = IOHelper.openFile(strings);
                loaded = true;
                edited = false;
                saved = false;
            } else if (menuInput.equalsIgnoreCase("s")) {
                save();
            } else if (menuInput.equalsIgnoreCase("c")) {
                clear();
            } else {
                if (quit()) {
                    boolean saveCheck = InputHelper.getYNConfirm(drake, "Would you like to save? Y or N");
                    if (saveCheck) {
                        save();
                    }
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
        for (int i = 0; i < strings.size(); i++) {
            System.out.print(i + " - " + strings.get(i) + ", ");
        }
        System.out.println();

        strings.remove(InputHelper.getRangedInt(drake, "What index would you like to delete?", 0, strings.size()));
        System.out.println();
    }

    public static void save() throws IOException {
        if (loaded) {
            IOHelper.writeFile(strings, fileName);
        } else {
            IOHelper.writeFile(strings, InputHelper.getNonZeroLenString(drake, "File Name: "));
        }

        saved = true;
        edited = false;

        if (!InputHelper.getYNConfirm(drake, "Would you like to keep working on this file?")) {
            clear();
            loaded = false;
        }
    }
    public static void view() {
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(i + " - " + strings.get(i));
        }
        System.out.println();
    }

    public static boolean quit() {
        return InputHelper.getYNConfirm(drake, "Are you sure you want to quit? [Y/N]");
    }

    public static void clear() {
        for (int i = 0; i < strings.size(); i++) {
            strings.remove(i);
        }
    }
}
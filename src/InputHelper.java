import java.util.Scanner;

public class InputHelper {
    public static void main(String[] args) {
        // Test methamphetamine/methods
        Scanner drake = new Scanner(System.in);

        boolean x = getYNConfirm(drake, "Please enter Y or N");
        System.out.println(x);
    }

    // This method loops until a valid integer input is received
    public static int getInt(Scanner in, String prompt) {
        boolean done = false;
        int x = 0;

        System.out.println(prompt);

        do {
            if (in.hasNextInt()) {
                x = in.nextInt();
                done = true;
            }
            else{
                System.out.println("Invalid input. Please try again.");
            }
            in.nextLine(); //clear buffer
        } while (!done);
        return x;
    }


    public static int getRangedInt(Scanner in, String prompt, int min, int max){
        boolean done = false;
        int x = 0;

        System.out.println(prompt);

        do {
            if (in.hasNextInt()) {
                x = in.nextInt();
                if (x >= min && x <= max) {
                    done = true;
                }
                else{
                    System.out.println("Out of range. Please try again.");
                }
            }
            else{
                System.out.println("Invalid input. Please try again.");
            }
            in.nextLine(); //clear buffer
        } while (!done);
        return x;
    }

    public static String getRegExString(Scanner kanye, String prompt, String regEx) {
        String input;
        boolean done = false;

        System.out.println(prompt);

        do {
            input = kanye.nextLine();

            if (input.matches(regEx)) {
                done = true;
            } else {
                System.out.println("Invalid input");
            }

        } while(!done);

        return input;
    }

    // This method loops until a valid integer input is received
    public static double getDouble(Scanner in, String prompt) {
        boolean done = false;
        double x = 0;

        System.out.println(prompt);

        do {
            if (in.hasNextDouble()) {
                x = in.nextDouble();
                done = true;
            }
            else{
                System.out.println("Invalid input. Please try again.");
            }
            in.nextLine(); //clear buffer
        } while (!done);
        return x;
    }

    public static double getRangedDouble(Scanner in, String prompt, int min, int max){
        boolean done = false;
        double x = 0;

        System.out.println(prompt);

        do {
            if (in.hasNextDouble()) {
                x = in.nextDouble();
                if (x >= min && x <= max) {
                    done = true;
                }
                else{
                    System.out.println("Out of range. Please try again.");
                }
            }
            else {
                System.out.println("Invalid input. Please try again.");
            }
            in.nextLine(); //clear buffer
        } while (!done);
        return x;
    }

    public static String getNonZeroLenString(Scanner in, String prompt) {
        boolean done = false;
        String x;

        System.out.println(prompt);

        do {
            x = in.nextLine();

            if (x.length() > 0) {
                done = true;
            } else {
                System.out.println("Error: length must be greater than 0.");
            }
        } while (!done);

        return x;
    }

    public static int getPositiveNonZeroInt(Scanner in, String prompt) {
        boolean done = false;
        int x;

        System.out.println(prompt);

        do {
            x = in.nextInt();
            if (x > 0) {
                done = true;
            } else {
                System.out.println("Error: number must be greater than 0.");
            }
        } while (!done);

        return x;
    }

    public static boolean getYNConfirm(Scanner in, String prompt) {
        boolean done = false;
        boolean x = false;
        String input;

        System.out.println(prompt);

        do {
            input = in.nextLine();
            if (input.equalsIgnoreCase("Y")) {
                x = true;
                done = true;
            } else if (input.equalsIgnoreCase("N")) {
                done = true;
            } else {
                System.out.println("Error: you must enter Y or N");
            }
        } while (!done);

        return x;
    }
}


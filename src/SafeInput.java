
import java.util.Scanner;

public class SafeInput
{

    public static int getInt(Scanner pipe, String prompt) {
        boolean done = false;
        int retValue = 0;
        String trash = "";

        do {
            System.out.println("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                retValue = pipe.nextInt();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a vlid int not: " + trash);
            }


        } while (!done);

        return retValue;

    }


    public static int getRangeint(Scanner pipe, String prompt, int low, int high) {
        boolean done = false;
        int retValue = 0;
        String trash = "";

        do {
            System.out.println("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                retValue = pipe.nextInt();
                pipe.nextLine();
                if (retValue >= low && retValue <= high)
                    done = true;
                else
                    System.out.println("You must enter a value in range: " + trash);

            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a value int not: " + trash);
            }
        } while (!done);

        return retValue;
    }


    public static double getDouble(Scanner pipe, String prompt) {
        boolean done = false;
        double retValue = 0;
        String trash = "";

        do {
            System.out.println("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                retValue = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a vlid double not: " + trash);
            }
        } while (!done);

        return retValue;

    }


    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        boolean done = false;
        double retValue = 0;
        String trash = "";

        do {
            System.out.println("\n" + prompt + "[" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                retValue = pipe.nextDouble();
                pipe.nextLine();
                if (retValue >= low && retValue <= high)
                    done = true;
                else
                    System.out.println("You must enter a value in range [\" + low + \" - \" + high + \"]:  " + trash);

            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a value double: " + trash);
            }
        } while (!done);

        return retValue;
    }


    /**
     * Gets a Y or N from user and retunr
     *
     * @param pipe   Scanner to use for input on system.in
     * @param prompt prompt for the user to know what to put
     * @parma A boolean true flase evivalent for y and n
     */

    public static boolean getYNConfire(Scanner pipe, String prompt) {
        String value = "";
        boolean retValue = false;
        boolean done = false;

        do {
            System.out.print("\n" + prompt + "[Y/N]: ");
            value = pipe.nextLine();

            if (value.equalsIgnoreCase("y")) {
                retValue = true;
                done = true;
            } else if (value.equalsIgnoreCase("n")) {
                retValue = false;
                done = true;
            } else {
                System.out.println("You must enter a Y or N not: " + value);
            }
        } while (!done);
        return retValue;
    }

    /**
     * Get a String that matches a suppiled regular expression
     *
     * @param pipe   scnnaaer
     * @param prompt
     * @param regEx
     * @return
     */

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String retValue = "";
        boolean done = false;
        do {
            System.out.print("\n" + prompt + " " + regEx + ": ");
            retValue = pipe.nextLine();

            if (retValue.matches(regEx)) {
                done = true;
            } else
                System.out.println("You must enter a String the matches thre pattern: " + regEx);

        } while (!done);

        return retValue;

    }

    /**
     * Get a string from the user that has at least one chnarater
     *
     * @param pipe   snaccer to use for the input on systen.in
     * @param prompt tells the user what to say
     * @return a non-zoro leght String
     */

    public static String getNonZeroLenghtString(Scanner pipe, String prompt) {
        String retValue = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + ": ");
            retValue = pipe.nextLine();

            if (retValue.length() > 0)
                done = true;
            else
                System.out.println("You must some characters!");


        } while (!done);

        return retValue;
    }

    public static String prettyHeader(String msg) {
        String retValue = "";
        int totalWidth = 60;
        int msgWidth = msg.length() + 6; // account for 3 stars on each side
        int sideWidth = (totalWidth - msgWidth) / 2;
        System.out.print("*".repeat(totalWidth) + "\n");
        System.out.print("***" + " ".repeat(sideWidth) + msg + " ".repeat(sideWidth) + "***\n");
        System.out.print("*".repeat(totalWidth));
        return retValue;
    }


    public static double CtoF(double celsius) {
        double fahrenheit = (celsius * 1.8) + 32;
        return fahrenheit;
    }











}// end of class

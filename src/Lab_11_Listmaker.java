import java.util.ArrayList;
import java.util.Scanner;

public class Lab_11_Listmaker{
    private static Scanner in = new Scanner(System.in);
    private static ArrayList<String> lines = new ArrayList<>();

    private static boolean isDirty = false; // Indicate that the current has not been saved.

    public static void main(String[] args) {
        String menuPrompt = "A - Add D - Delete P - Print Q - Quit";
        String cmd = ""; // A D P or Q

        while (true) {
            showList();
            cmd = SafeInput.getRegExString(in, menuPrompt, "[AaDdPpQq]");
            cmd = cmd.toUpperCase();

            switch (cmd) {
                case "A":
                    add();
                    isDirty = true;
                    break;
                case "D":
                    delete();
                    isDirty = true;
                    break;
                case "P":
                    showList();
                    break;
                case "Q":
                    if (!isDirty || SafeInput.getYNConfire(in, "Are you sure you want to quit?")) {
                        System.exit(0);
                    }
                    break;
            }
        }
    }

    public static void showList() {
        System.out.println("-----------------------------------------------");
        if (lines.size() == 0) {
            System.out.println("\nThe list is currently empty.\n");
        } else {
            for (int i = 0; i < lines.size(); i++) {
                System.out.println("\t" + (i + 1) + ". " + lines.get(i));
            }
        }
        System.out.println("-----------------------------------------------");
    }

    public static void add() {
        String lineItem = SafeInput.getNonZeroLenghtString(in, "Enter the new line for the memo");
        lines.add(lineItem);
    }

    private static void delete() {
        System.out.println("------------------------------------");
        if (lines.size() == 0) {
            System.out.println("\nNothing to delete.\n");
            System.out.println("--------------------------------");
            return;
        }

        int target = SafeInput.getRangeint(in, "Enter the number of the line you want to delete", 1, lines.size());

        lines.remove(target - 1);
    }
}

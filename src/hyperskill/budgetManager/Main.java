package hyperskill.budgetManager;

1st import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static double balance = 0.0;
    private static List listOfPurchases = new ArrayList();
    private static final String MENU = """
            Choose your action:
            1) Add income
            2) Add purchase
            3) Show list of purchases
            4) Balance
            0) Exit""";
    public static void main(String[] args) {
        System.out.println(MENU);

        double sum = 0.0;
        Scanner scanner = new Scanner(System.in);
        List<String> result = new ArrayList<>();
        while(scanner.hasNext()) {
            String input = scanner.nextLine();
            String number = input.split("\\$")[1];
            sum += Double.parseDouble(number);
            result.add(input);
        }
        result.add("");
        result.add("Total: $" + sum);
        for (String i: result) {
            System.out.println(i);
        }
    }

    public static void addIncome() {

    }

    public static void addPurchase() {

    }

    public static void printList() {
        System.out.println(listOfPurchases);
    }

    public static void printBalance() {
        System.out.println(balance);
    }
}

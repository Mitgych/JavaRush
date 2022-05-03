package numbers;

import java.util.*;

public class ReadInput {
    static final String ERROR1 = "The first parameter should be a natural number or zero,\n";
    static final String ERROR2 = "The second parameter should be a natural number.\n";
    static final String ERROR3 = "The property [%s] is wrong.\n" +
            "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY]";
    public static List<String> input() {
        List<String> result = new ArrayList<>();
        int count = 0;
        String buffer;
        final String[] properties = {"EVEN", "ODD", "BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY"};

        Scanner scanner  = new Scanner(System.in);
        buffer = scanner.nextLine();
        Scanner read  = new Scanner(buffer);
        while (read.hasNext()) {
            result.add(read.next());
        }
        if (buffer.isEmpty()) { //check empty input
            System.out.println(Main.INSTRUCTION);
            result = input();
        } else if (result.size() > 0 && Long.parseLong(result.get(0)) < 0) { //check first number < 0
            System.out.println(ERROR1);
            System.out.print("\nEnter a request: ");
            result = input();
        } else if (result.size() > 1 && Long.parseLong(result.get(1)) < 0) {
            System.out.println(ERROR2);
            System.out.print("\nEnter a request: ");
            result = input();
        } else if (result.size() > 2 && !Arrays.stream(properties).anyMatch(result.get(2).toUpperCase()::equals)) {
            System.out.printf(ERROR3, result.get(2));
            System.out.print("\nEnter a request: ");
            result = input();
        }
        return result;
        //System.out.println();
    }
}

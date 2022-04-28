package numbers;

import java.util.Scanner;

public class ReadInput {

    public static long[] inputNumb() {
        long[] result = {-1, -1};
        int count = 0;
        String buffer;

        Scanner scanner  = new Scanner(System.in);
        buffer = scanner.nextLine();
        Scanner read  = new Scanner(buffer);
        while (read.hasNextLong()) {
            result[count] = read.nextLong();
            count++;
        }
        if (result[0] == 0) { //TODO: is it still need?
            //it's correct input
        } else if (buffer.isEmpty()) { //check empty input
            System.out.println(Main.INSTRUCTION);
            result = inputNumb();
            System.out.println();
        } else if (result[0] == -1 || result[0] < 0) { //check not number input or number < 0
            System.out.println(Main.ERROR1);
            System.out.print("\nEnter a request: ");
            result = inputNumb();
            System.out.println();
        } else if (result[1] < 0 && result[1] != -1) {
            System.out.println(Main.ERROR2);
            System.out.print("\nEnter a request: ");
            result = inputNumb();
            System.out.println();
        }
        return result;
    }
}

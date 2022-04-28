import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int i = 0;
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLong());
                i++;
                System.out.println(i);
            }
        } catch (InputMismatchException e) {
            System.out.println("ERROR!!!!");
        }
    }

}
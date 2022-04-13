package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a natural number:");
        int readNumber = scanner.nextInt();
        scanner.close();
        if (readNumber > 0) {
            //if (number % 2 == 0) {
            //    System.out.println("This number is Even.");
            //} else {
            //    System.out.println("This number is Odd.");
            //}
            //if (number % 10 == 7) {
            //    if (number % 7 == 0) {
            //        System.out.println("It is a Buzz number.\nExplanation:\n" + 
            //                number + " is divisible by 7 and ends with 7");
            //    } else {
            //        System.out.println("It is a Buzz number.\nExplanation:\n" + 
            //                number + " ends with 7");
            //    }
            //} else {
            //    if (number % 7 == 0) {
            //        System.out.println("It is a Buzz number.\nExplanation:\n" + 
            //                number + " is divisible by 7");
            //    } else {
            //        System.out.println("It is not a Buzz number.\nExplanation:\n" + 
            //                number + " is neither divisible by 7 nor does it end with 7");
            //    }
            //}
            Number number = new Number(readNumber);
            System.out.println("Properties of " + number.value +
                    "\neven: " +  number.isEven + 
                    "\nodd: " + number.isOdd + 
                    "\nbuzz: " + number.isBuzz + 
                    "\nduck: " + number.isDuck);
        } else {
            System.out.println("This number is not natural!");
        }
    }

    public static class Number {
        private int value;
        private boolean isBuzz;
        //private boolean divisibleBySeven;
        //private boolean EndsWithSeven;
        private boolean isOdd;
        private boolean isEven;
        private boolean isDuck;

        public Number(int number) {
            this.value = number;
            
            if (number % 2 == 0) {
                this.isOdd = false;
                this.isEven = true;
            } else {
                this.isOdd = true;
                this.isEven = false;
            }

            //if (number % 10 == 7) {
            //    this.EndsWithSeven= true;
            //} else {
            //    this.EndsWithSeven= false;
            //}
//
            //if (number % 7 == 0) {
            //    this.divisibleBySeven= true;
            //} else {
            //    this.divisibleBySeven= false;
            //}

            if (number % 7 == 0 || number % 10 == 7) {
                this.isBuzz = true;
            } else {
                this.isBuzz = false;
            }
        }
    }
}

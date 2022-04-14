package numbers;

public class Number {
    private long value;
    private boolean isBuzz;
    private boolean isOdd;
    private boolean isEven;
    private boolean isDuck;
    private boolean isPalindromic;


    public Number(long number) {
        this.value = number;
        
        if (number % 2 == 0) {
            this.isOdd = false;
            this.isEven = true;
        } else {
            this.isOdd = true;
            this.isEven = false;
        }

        if (number % 7 == 0 || number % 10 == 7) {
            this.isBuzz = true;
        } else {
            this.isBuzz = false;
        }

        String numberAsString = Long.toString(number);
        if (numberAsString.charAt(0) == '0') {
            numberAsString = numberAsString.substring(1);
        }
        if (numberAsString.contains("0")) {
            this.isDuck = true;
        } else {
            this.isDuck = false;
        }

        var str1 = Long.toString(number);
        var str = new StringBuilder(str1);
        if (str.reverse().toString().equals(str1)) {
            this.isPalindromic = true;
        } else {
            this.isPalindromic = false;
        }
    }


    public void print() {
        System.out.println("Properties of " + this.value +
                    "\n       even: " +  this.isEven + 
                    "\n        odd: " + this.isOdd + 
                    "\n       buzz: " + this.isBuzz + 
                    "\n       duck: " + this.isDuck + 
                    "\npalindromic: " + this.isPalindromic);
    }
}

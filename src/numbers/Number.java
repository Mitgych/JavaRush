package numbers;

public class Number {
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

        String numberAsString = Integer.toString(number);
        if (numberAsString.charAt(0) == '0') {
            numberAsString = numberAsString.substring(1);
        }
        if (numberAsString.contains("0")) {
            this.isDuck = true;
        } else {
            this.isDuck = false;
        }
    }


    public void print() {
        System.out.println("Properties of " + this.value +
                    "\neven: " +  this.isEven + 
                    "\nodd: " + this.isOdd + 
                    "\nbuzz: " + this.isBuzz + 
                    "\nduck: " + this.isDuck);
    }
}

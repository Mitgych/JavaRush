package tests;

public class Main {
    public static void main(String[] args) {
        Vector v1 = ZeroVector.INSTANCE;
        Vector v2 = new ArrayVector(1, 2, 3);
        Vector v3 = new FieldVector(4, 5, 6);

        Vector sum = v1.plus(v2).plus(v3);
        System.out.println(sum instanceof ArrayVector);
    }
}

package testInterface;

public class ArrayVector implements Vector{
    double[] arr;

    ArrayVector(double x, double y, double z) {
        arr = new double[] {x, y, z};
    }

    @Override
    public double component(int n) {
        return arr[n];
    }

    @Override
    public double length() {
        return 0;
    }

    @Override
    public Vector plus(Vector other) {
        return new ArrayVector(arr[0] + other.component(0),
                                arr[1] + other.component(1),
                                arr[2] + other.component(2));
    }
}

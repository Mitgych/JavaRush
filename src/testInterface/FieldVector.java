package testInterface;

public class FieldVector implements Vector{
    double x, y, z;

    FieldVector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public double component(int n) {
        return switch (n) {
            case 0 -> x;
            case 1 -> y;
            case 2 -> z;
            default -> throw new IllegalArgumentException();
        };
    }

    @Override
    public double length() {
        return 0;
    }

    @Override
    public Vector plus(Vector other) {
        return new ArrayVector(this.x + other.component(0),
                this.y + other.component(1),
                this.z + other.component(2));
    }
}

package testInterface;

public interface Vector {
    /**
     * Retuns a vector component
     * @param n component number, must be 0 (X), 1 (Y), 2 (Z)
     * @return a value of the corresponding vector component
     */
    double component(int n);

    /**
     *
     * @return a vector length
     */
    double length();

    /**
     * Sums two vectors
     * @param other a vector to add to this vector
     * @return a result of addition
     */
    Vector plus(Vector other);
}

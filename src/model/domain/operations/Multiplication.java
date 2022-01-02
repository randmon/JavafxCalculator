package model.domain.operations;

public class Multiplication implements Operation {
    @Override
    public String calculate(double x, double y) {
        return String.valueOf(((long) x) * ((long) y));
    }

    @Override
    public String toString() {
        return "*";
    }
}

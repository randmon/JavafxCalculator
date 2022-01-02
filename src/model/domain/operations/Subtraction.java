package model.domain.operations;

public class Subtraction implements Operation {
    @Override
    public String calculate(double x, double y) {
        return formatDouble(x - y);
    }

    @Override
    public String toString() {
        return "-";
    }
}

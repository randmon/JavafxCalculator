package model.domain.operations;

public class Division implements Operation {
    @Override
    public String calculate(double x, double y) {
        if (y == 0) return "0";
        return formatDouble(x / y);
    }

    @Override
    public String toString() {
        return "/";
    }
}

package model.domain.operations;

public interface Operation {
    String calculate(double x, double y);

    default String formatDouble(double d) {
        int noDecimals = (int) d;
        double rounded = Math.round(d * 1000000000.0) / 1000000000.0;

        return rounded == noDecimals ? String.valueOf(noDecimals) : String.valueOf(rounded);
    }
}

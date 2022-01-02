package model.domain;

import model.domain.operations.Addition;
import model.domain.operations.Operation;

public class Calculator {
    private Operation operation;
    private double x, y;
    private boolean xPointed, yPointed;
    private String xDecimal, yDecimal;

    public Calculator() {
        operation = new Addition();
        x = 0;
        y = 0;
        xPointed = false;
        yPointed = false;
        xDecimal = "";
        yDecimal = "";
    }

    public String calculate() {
        return operation.calculate(x, y);
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getX() {
        if (xPointed) {
            if (x < 0) {
                return "-" + (int) Math.ceil(x) + "." + xDecimal;
            } else {
                return (int) Math.floor(x) + "." + xDecimal;
            }
        } else {
            return operation.formatDouble(x);
        }
    }

    public String getY() {
        if (yPointed) {
            if (y < 0) {
                return "-" + (int) Math.floor(Math.abs(y)) + "." + yDecimal;
            } else {
                return (int) Math.floor(y) + "." + yDecimal;
            }
        } else {
            return operation.formatDouble(y);
        }
    }

    public void setX(String current, String s) {
        if (current.length() > 7) return;
        try {
            double d;
            if (xPointed) {
                xDecimal += s;
                int i;
                if (x >= 0) {
                    i = (int) Math.floor(x);
                    d = Double.parseDouble(i + "." + xDecimal);
                } else {
                    i = Math.abs((int) Math.ceil(x));
                    d = Double.parseDouble("-" + i + "." + xDecimal);
                }
            } else {
                d = Double.parseDouble(current + s);
            }
            x = d;
        } catch (NumberFormatException ignored) {
        }
    }

    public void setY(String current, String s) {
        if (current.length() > 7) return;
        try {
            double d;
            if (yPointed) {
                yDecimal += s;
                int i;
                if (y >= 0) {
                    i = (int) Math.floor(y);
                    d = Double.parseDouble(i + "." + yDecimal);

                } else {
                    i = (int) Math.ceil(y);
                    d = Double.parseDouble("-" + i + "." + yDecimal);
                }
            } else {
                d = Double.parseDouble(current + s);
            }
            y = d;
        } catch (NumberFormatException ignored) {
        }
    }

    public void deleteX() {
        x = 0;
        xDecimal = "";
        xPointed = false;
    }

    public void deleteY() {
        y = 0;
        yDecimal = "";
        yPointed = false;
    }

    public void inverseX() {
        x = x * -1;
    }

    public void inverseY() {
        y = y * -1;
    }

    public void setxPointed(boolean xPointed) {
        this.xPointed = xPointed;
    }

    public void setyPointed(boolean yPointed) {
        this.yPointed = yPointed;
    }
}

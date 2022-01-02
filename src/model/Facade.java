package model;

import model.domain.Calculator;
import model.domain.CalculatorEvent;
import model.domain.operations.OperationFactory;

public class Facade extends Observable {
    private Calculator calculator;

    public Facade() {
        calculator = new Calculator();
    }

    public String getOperation() {
        return calculator.getOperation().toString();
    }

    public void setOperation(String name) {
        calculator.setOperation(OperationFactory.getInstance().getOperation(name));
        updateAll(CalculatorEvent.SETOPERATION);
    }

    public String getX() {
        return calculator.getX();
    }

    public String getY() {
        return calculator.getY();
    }

    public void writeNumber(String field, String current, String n) {
        if (field.equals("x")) calculator.setX(current, n);
        else if (field.equals("y")) calculator.setY(current, n);
        else throw new IllegalArgumentException("Invalid field");

        updateAll(CalculatorEvent.WRITE);
    }

    public String calculate() {
        return calculator.calculate();
    }

    public void delete(String field) {
        if (field.equals("x")) {
            calculator.deleteX();
        }
        else if (field.equals("y")) {
            calculator.deleteY();
        }
        else throw new IllegalArgumentException("Invalid field");

        updateAll(CalculatorEvent.WRITE);
    }

    public void inverse(String field) {
        if (field.equals("x")) calculator.inverseX();
        else if (field.equals("y")) calculator.inverseY();
        else throw new IllegalArgumentException("Invalid field");

        updateAll(CalculatorEvent.WRITE);
    }

    public void setPoint(String field) {
        if (field.equals("x")) calculator.setxPointed(true);
        else if (field.equals("y")) calculator.setyPointed(true);
        else throw new IllegalArgumentException("Invalid field");

        updateAll(CalculatorEvent.WRITE);
    }
}

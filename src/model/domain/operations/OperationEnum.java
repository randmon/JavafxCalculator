package model.domain.operations;

public enum OperationEnum {
    ADDITION("Addition"),
    SUBTRACTION("Subtraction"),
    MULTIPLICATION("Multiplication"),
    DIVISION("Division");

    private final String name;

    OperationEnum(String name) {
        this.name = name;
    }

    public String getClassName() {
        return "model.domain.operations." + name;
    }
}

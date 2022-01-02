package model.domain.operations;

public class OperationFactory {
    public static OperationFactory instance;

    public Operation getOperation(String name) {
        OperationEnum operationEnum = OperationEnum.valueOf(name);
        String className = operationEnum.getClassName();
        try {
            Class<?> operationClass = Class.forName(className);
            return (Operation) operationClass.newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid operation");
        }
    }

    public static OperationFactory getInstance() {
        if (instance == null) instance = new OperationFactory();
        return instance;
    }

}

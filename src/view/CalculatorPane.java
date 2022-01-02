package view;

import controller.Controller;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Arrays;

public class CalculatorPane {
    private final Controller controller;
    private final GridPane grid;

    private Button fieldX, fieldY;
    private TextField result;
    private Label operation;

    private Button selectedField;
    private String selectedFieldLetter;

    public CalculatorPane(Controller controller, GridPane grid) {
        this.controller = controller;
        this.grid = grid;

        createButtons();
        createRightFields();
    }

    private void createButtons() {
        Button b7 = new Button("7");
        grid.add(b7, 0, 0, 1, 1);
        Button b8 = new Button("8");
        grid.add(b8, 1, 0, 1, 1);
        Button b9 = new Button("9");
        grid.add(b9, 2, 0, 1, 1);

        Button b4 = new Button("4");
        grid.add(b4, 0, 1, 1, 1);
        Button b5 = new Button("5");
        grid.add(b5, 1, 1, 1, 1);
        Button b6 = new Button("6");
        grid.add(b6, 2, 1, 1, 1);

        Button b1 = new Button("1");
        grid.add(b1, 0, 2, 1, 1);
        Button b2 = new Button("2");
        grid.add(b2, 1, 2, 1, 1);
        Button b3 = new Button("3");
        grid.add(b3, 2, 2, 1, 1);

        Button bPlusMinus = new Button("+/-");
        grid.add(bPlusMinus, 0, 3, 1, 1);
        bPlusMinus.setOnAction(event -> controller.inverse());

        Button b0 = new Button("0");
        grid.add(b0, 1, 3, 1, 1);

        Button bPoint = new Button(".");
        grid.add(bPoint, 2, 3, 1, 1);
        bPoint.setOnAction(event -> controller.setPoint());

        Button bPlus = new Button("+");
        bPlus.getStyleClass().add("operation");
        grid.add(bPlus, 3, 0, 1, 1);
        bPlus.setOnAction(event -> controller.setOperation("ADDITION"));

        Button bMinus = new Button("-");
        bMinus.getStyleClass().add("operation");
        grid.add(bMinus, 3, 1, 1, 1);
        bMinus.setOnAction(event -> controller.setOperation("SUBTRACTION"));

        Button bMultiply = new Button("*");
        bMultiply.getStyleClass().add("operation");
        grid.add(bMultiply, 3, 2, 1, 1);
        bMultiply.setOnAction(event -> controller.setOperation("MULTIPLICATION"));

        Button bDivide = new Button("/");
        bDivide.getStyleClass().add("operation");
        grid.add(bDivide, 3, 3, 1, 1);
        bDivide.setOnAction(event -> controller.setOperation("DIVISION"));

        Button bEquals = new Button("=");
        bEquals.getStyleClass().add("equals");
        grid.add(bEquals, 0, 5, 3, 1);
        bEquals.setOnAction(event -> controller.calculate());

        Button bDelete = new Button("⬅");
        bDelete.getStyleClass().add("delete");
        grid.add(bDelete, 3, 5, 1, 1);
        bDelete.setOnAction(event -> controller.delete());

        ArrayList<Button> numbers = new ArrayList<>(Arrays.asList(b0, b1, b2, b3, b4, b5, b6, b7, b8, b9));
        for (Button b : numbers) {
            b.setOnAction(click -> {
                controller.writeNumber(b.getText());
            });
        }
    }

    private void createRightFields() {
        VBox rightVBox = new VBox(15);
        rightVBox.getStyleClass().add("rightVBox");
        grid.add(rightVBox, 7, 0, 4, 6);

        fieldX = new Button();
        rightVBox.getChildren().add(fieldX);
        fieldX.getStyleClass().add("xyFields");
        selectedField = fieldX; //DEFAULT - start writing top numbers
        fieldX.getStyleClass().add("selectedField");
        selectedFieldLetter = "x";
        fieldX.setOnAction(event -> {
            selectedField = fieldX;
            selectedFieldLetter = "x";
            fieldX.getStyleClass().add("selectedField");
            fieldY.getStyleClass().clear();
            fieldY.getStyleClass().add("xyFields");
            fieldY.getStyleClass().add("button");
        });
        fieldX.setText(controller.getX());

        operation = new Label(controller.getOperation());
        rightVBox.getChildren().add(operation);

        fieldY = new Button();
        rightVBox.getChildren().add(fieldY);
        fieldY.getStyleClass().add("xyFields");
        fieldY.setOnAction(event -> {
            selectedField = fieldY;
            selectedFieldLetter = "y";
            fieldY.getStyleClass().add("selectedField");
            fieldX.getStyleClass().clear();
            fieldX.getStyleClass().add("xyFields");
            fieldX.getStyleClass().add("button");
        });
        fieldY.setText(controller.getY());

        Label equals = new Label("=");
        rightVBox.getChildren().add(equals);

        result = new TextField();
        result.setEditable(false);
        rightVBox.getChildren().add(result);
    }

    public void showResult(String result) {
        this.result.setText(result);
    }

    public void setOperation(String operation) {
        result.setText("");
        this.operation.setText(operation);
    }

    public String getSelected() {
        return selectedField.getText();
    }

    public String getSelectedField() {
        return selectedFieldLetter;
    }

    public void updateXYFields() {
        result.setText("");
        fieldX.setText(controller.getX());
        fieldY.setText(controller.getY());
    }
}

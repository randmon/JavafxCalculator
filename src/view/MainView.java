package view;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainView {
    private Stage stage = new Stage();
    private GridPane grid = new GridPane();
    private int width = 600;
    private int height = 350;
    private CalculatorPane calculatorPane;

    public MainView(Controller controller) {
        controller.setView(this);
        Group root = new Group();
        Scene scene = new Scene(root, width, height);
        scene.getStylesheets().add("calculator.css");
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.getStyleClass().add("grid");
        grid.setPrefHeight(height);
        grid.setPrefWidth(width);
        root.getChildren().add(grid);

        calculatorPane = new CalculatorPane(controller, grid);

        stage.setTitle("Calculator");
        stage.getIcons().add(new Image("icon.png"));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    public void showResult(String result) {
        calculatorPane.showResult(result);
    }

    public void setOperation(String operation) {
        calculatorPane.setOperation(operation);
    }

    public String getSelected() {
        return calculatorPane.getSelected();
    }

    public String getSelectedField() {
        return calculatorPane.getSelectedField();
    }

    public void updateXYFields() {
        calculatorPane.updateXYFields();
    }
}

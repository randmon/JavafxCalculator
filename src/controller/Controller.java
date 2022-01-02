package controller;

import model.Facade;
import model.domain.CalculatorEvent;
import view.MainView;


public class Controller implements Observer {
    private MainView view;
    private Facade facade;

    public Controller(Facade facade) {
        this.facade = facade;
        facade.addObserver(this);
    }

    @Override
    public void update(CalculatorEvent event) {
        switch (event) {
            case SETOPERATION:
                view.setOperation(getOperation());
                break;
            case WRITE:
                view.updateXYFields();
                break;
        }
    }

    public void setView(MainView view) {
        this.view = view;
    }

    public String getOperation() {
        return facade.getOperation();
    }

    public void setOperation(String name) {
        facade.setOperation(name);
    }

    public String getX() {
        return facade.getX();
    }

    public String getY() {
        return facade.getY();
    }

    public void writeNumber(String n) {
        String current = view.getSelected();
        String field = view.getSelectedField();

        facade.writeNumber(field, current, n);
    }

    public void calculate() {
        view.showResult(facade.calculate());
    }

    public void delete() {
        facade.delete(view.getSelectedField());
    }

    public void inverse() {
        facade.inverse(view.getSelectedField());
    }

    public void setPoint() {
        facade.setPoint(view.getSelectedField());
    }
}

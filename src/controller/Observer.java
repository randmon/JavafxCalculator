package controller;

import model.domain.CalculatorEvent;

public interface Observer {
    void update(CalculatorEvent event);
}

package model;

import controller.Observer;
import model.domain.CalculatorEvent;

import java.util.HashSet;
import java.util.Set;

public class Observable {
    Set<Observer> observers;

    public Observable() {
        observers = new HashSet<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void updateAll(CalculatorEvent event) {
        for (Observer o : observers) {
            o.update(event);
        }
    }
}

package BakeryDesign;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private List<Observer> observers = new ArrayList<>();
    private String cakeName;

    public void setCake(String cakeName) {
        this.cakeName = cakeName;
        notifyObservers();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(cakeName);
        }
    }
}

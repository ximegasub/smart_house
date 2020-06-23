import java.util.ArrayList;

public abstract class Observable {
    private ArrayList<Observer> observers = new ArrayList();

    abstract void setState(String state);
    abstract String getState();
    abstract void setUnits(String units);
    abstract String getUnits();

    public void activate(Observer observer){
        this.observers.add(observer);
    }

    public void deactivate(Observer observer){
        this.observers.remove(observer);
    }

    public void notifyObservers(){
        for (Observer observer : this.observers){
            observer.update();
        }
    }
}

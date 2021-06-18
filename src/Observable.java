import java.util.ArrayList;

public abstract class Observable {
    private ArrayList<Observer> observers = new ArrayList();
    protected boolean state;
    protected String units;

    abstract void setState(String state);
    abstract boolean getState();
    abstract void setUnits(String units);
    abstract String getUnits();
    abstract boolean verifyState(String state);

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

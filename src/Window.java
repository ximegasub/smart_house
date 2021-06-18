public class Window extends Device implements Observer{

    public Window(){
        this.deviceOn = false;
    }

    public Window(Observable observable, String place){
        this.place = place;
        this.deviceOn = false;
        this.observable = observable;
        observable.activate(this);
    }

    @Override
    public void definePlace(String place) {
        this.place = place;
    }

    @Override
    public void defineObservable(Observable observable) {
        this.observable = observable;
        observable.activate(this);
    }

    public boolean verifyState(Observable observable){
        if (observable instanceof Cinema){
            boolean state = observable.getState();
            if (state){
                return false;
            }else{
                return true;
            }
        }
        return observable.getState();
    }

    @Override
    public void update(){
        boolean sensorStatus = this.verifyState(observable);
        if (sensorStatus){
            deviceOn("Opening windows from the "+ this.place);
        }
        else{
            deviceOff("Closing windows from the "+ this.place);
        }
    }
}


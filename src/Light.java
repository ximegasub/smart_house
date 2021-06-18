public class Light extends Device implements Observer  {

    public Light(){
        this.deviceOn = false;
    }

    public Light(Observable observable, String place){
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

    @Override
    public void update(){
        boolean sensorStatus = observable.getState();
        if (sensorStatus){
            deviceOn("Turning on lights from the "+ this.place);
        }
        else{
            deviceOff("Turning off lights from the "+ this.place);
        }
    }
}

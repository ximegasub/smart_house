public class AirConditioning extends Device implements Observer{

    public AirConditioning(){
        this.deviceOn = false;
    }

    public AirConditioning(Observable observable, String place){
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
            deviceOn("Turning on air conditioning from the "+ this.place);
        }
        else{
            deviceOff("Turning off air conditioning from the "+ this.place);
        }
    }
}
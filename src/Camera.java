public class Camera extends Device implements Observer{

    public Camera(){
        this.deviceOn = false;
    }

    public Camera(Observable observable, String place){
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
            deviceOn("Turning on camera from the "+ this.place);
        }
        else{
            deviceOff("Turning off camera from the "+ this.place);
        }
    }
}
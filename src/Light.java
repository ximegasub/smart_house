public class Light implements Observer{
    private boolean lightOn;
    private String place;
    private Observable observable;

    public Light(){
        this.lightOn = false;
    }

    public Light(Observable observable, String place){
        this.place = place;
        this.lightOn = false;
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
            turnOnLight();
        }
        else{
            turnOffLight();
        }
    }

    public boolean getLightOn(){
        return this.lightOn;
    }

    public String getPlace(){
        return this.place;
    }

    public void turnOnLight(){
        if(!lightOn){
            System.out.println("Turning on lights from the "+ this.place);
            lightOn = true;
        }
    }

    public void turnOffLight(){
        if(!lightOn){
            System.out.println("Turning off lights from the "+ this.place);
            lightOn = false;
        }
    }
}

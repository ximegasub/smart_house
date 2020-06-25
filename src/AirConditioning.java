public class AirConditioning implements Observer{
    private boolean airOn;
    private String place;
    private Observable observable;

    public AirConditioning(){
        this.airOn = false;
    }

    public AirConditioning(Observable observable, String name){
        this.place = name;
        this.airOn = false;
        this.observable = observable;
        observable.activate(this);
    }

    @Override
    public void definePlace(String name) {
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
            turnOnAir();
        }
        else{
            turnOffAir();
        }
    }
    public boolean getAirOn(){
        return this.airOn;
    }

    public String getPlace(){
        return this.place;
    }

    public void turnOnAir(){
        if(!airOn){
            System.out.println("Turning on air conditioning from the "+ this.place);
            airOn = true;
        }
    }

    public void turnOffAir(){
        if(!airOn){
            System.out.println("Turning off air conditioning from the "+ this.place);
            airOn = false;
        }
    }
}
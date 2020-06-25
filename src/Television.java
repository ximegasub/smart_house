public class Television implements Observer{
    private boolean tvOn;
    private String place;
    private Observable observable;

    public Television(){
        this.tvOn = false;
    }

    public Television(Observable observable, String name){
        this.place = name;
        this.tvOn = false;
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
            turnOnTv();
        }
        else{
            turnOffTv();
        }
    }

    public boolean getLightOn(){
        return this.tvOn;
    }

    public String getPlace(){
        return this.place;
    }

    public void turnOnTv(){
        if(!tvOn){
            System.out.println("Turning on television from the "+ this.place);
            tvOn = true;
        }
    }

    public void turnOffTv(){
        if(!tvOn){
            System.out.println("Turning off television from the "+ this.place);
            tvOn = false;
        }
    }
}


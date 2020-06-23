public class Light implements Observer{
    private boolean lightOn;
    private String name;
    private Observable observable;

    public Light(){
        this.lightOn = false;
    }

    public Light(Observable observable, String name){
        this.name = name;
        this.lightOn = false;
        this.observable = observable;
        observable.activate(this);
    }

    @Override
    public void fillName(String name) {
        this.name = name;
    }

    @Override
    public void fillObservable(Observable observable) {
        this.observable = observable;
        observable.activate(this);
    }

    @Override
    public void update(){
        boolean sensorStatus = Boolean.valueOf(observable.getState());
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

    public String getName(){
        return this.name;
    }

    public void turnOnLight(){
        if(!lightOn){
            System.out.println("Turning on lights from the "+ name);
            lightOn = true;
        }
    }

    public void turnOffLight(){
        if(!lightOn){
            System.out.println("Turning off lights from the "+ name);
            lightOn = false;
        }
    }
}

public class Camera implements Observer{
    private boolean cameraOn;
    private String place;
    private Observable observable;

    public Camera(){
        this.cameraOn = false;
    }

    public Camera(Observable observable, String place){
        this.place = place;
        this.cameraOn = false;
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
            turnOnCamera();
        }
        else{
            turnOffCamera();
        }
    }
    public boolean getCameraOn(){
        return this.cameraOn;
    }

    public String getPlace(){
        return this.place;
    }

    public void turnOnCamera(){
        if(!cameraOn){
            System.out.println("Turning on camera from the "+ this.place);
            cameraOn = true;
        }
    }

    public void turnOffCamera(){
        if(!cameraOn){
            System.out.println("Turning off camera from the "+ this.place);
            cameraOn = false;
        }
    }
}
public class Camera implements Observer{
    private boolean cameraOn;
    private String name;
    private Observable observable;

    public Camera(){
        this.cameraOn = false;
    }

    public Camera(Observable observable, String name){
        this.name = name;
        this.cameraOn = false;
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
            turnOnCamera();
        }
        else{
            turnOffCamera();
        }
    }
    public boolean getCameraOn(){
        return this.cameraOn;
    }

    public String getName(){
        return this.name;
    }

    public void turnOnCamera(){
        if(!cameraOn){
            System.out.println("Turning on camera from the "+ name);
            cameraOn = true;
        }
    }

    public void turnOffCamera(){
        if(!cameraOn){
            System.out.println("Turning off camera from the "+ name);
            cameraOn = false;
        }
    }
}
public class Window implements Observer{
    private boolean isOpen;
    private String place;
    private Observable observable;

    public Window(){
        this.isOpen = false;
    }

    public Window(Observable observable, String place){
        this.place = place;
        this.isOpen = false;
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

    public boolean verify_state(Observable observable){
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
        boolean sensorStatus = this.verify_state(observable);
        if (sensorStatus){
            openWindow();
        }
        else{
            closeWindow();
        }
    }

    public boolean getIsOpen(){
        return this.isOpen;
    }

    public String getPlace(){
        return this.place;
    }

    public void openWindow(){
        if(!isOpen){
            System.out.println("Opening windows from the "+ this.place);
            isOpen = true;
        }
    }

    public void closeWindow(){
        if(!isOpen){
            System.out.println("Closing windows from the "+ this.place);
            isOpen = false;
        }
    }
}


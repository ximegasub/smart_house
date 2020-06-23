public class AirConditioning implements Observer{
    private boolean airOn;
    private String name;
    private Observable observable;

    public AirConditioning(){
        this.airOn = false;
    }

    public AirConditioning(Observable observable, String name){
        this.name = name;
        this.airOn = false;
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

    private Integer conversionToC(Integer temperature){
        int result = (temperature - 32)*5/9;
        return result;
    }

    @Override
    public void update(){
        int sensorSignal = Integer.parseInt(observable.getState());
        String sensorUnits = observable.getUnits();
        int temperature = sensorSignal;
        if ("fahrenheit".equals(sensorUnits)){
            temperature = this.conversionToC(sensorSignal);
        }
        if (temperature <= 0 && temperature <= 20){
            turnOffAir();
        }
        else if (temperature > 20){
            turnOnAir();
        }
    }
    public boolean getAirOn(){
        return this.airOn;
    }

    public String getName(){
        return this.name;
    }

    public void turnOnAir(){
        if(!airOn){
            System.out.println("Turning on air conditioning from the "+ name);
            airOn = true;
        }
    }

    public void turnOffAir(){
        if(!airOn){
            System.out.println("Turning off air conditioning from the "+ name);
            airOn = false;
        }
    }
}
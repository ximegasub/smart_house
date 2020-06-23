public class Temperature extends Observable {
    private String temperatureSignal;
    private String units;

    public Temperature(){
        this.temperatureSignal = "0";
        this.units = null;
    }

    @Override
    public String getState(){
        return this.temperatureSignal;
    }

    @Override
    public void setUnits(String units) {
        this.units = units;
    }

    @Override
    public String getUnits() {
        return this.units;
    }

    @Override
    public void setState(String signal){
        this.temperatureSignal = signal;
        System.out.println("Temperature Sensor state changes to " + this.temperatureSignal + "(" + this.units + ")");
        this.notifyObservers();
    }
}

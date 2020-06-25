public class Temperature extends Observable {
    private boolean temperatureSignal;
    private String units;

    public Temperature(){
        this.temperatureSignal = false;
        this.units = null;
    }

    @Override
    public boolean getState(){
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

    private Integer conversionToC(Integer temperature){
        int result = (temperature - 32)*5/9;
        return result;
    }

    public boolean establishState(String signal){
        boolean actualState = false;
        try {
            int sensorSignal = Integer.parseInt(signal);
            int temperature = sensorSignal;
            if ("fahrenheit".equals(this.units)) {
                temperature = this.conversionToC(sensorSignal);
            }
            if (temperature <= 0 && temperature <= 20) {
                actualState = false;
            } else if (temperature > 20) {
                actualState = true;
            }
        }catch (NumberFormatException e){
            System.out.println("The sensor state: "+ signal +" is not valid. The devices won't be activated.");
        }finally {
            return actualState;
        }
    }

    @Override
    public void setState(String signal){
        this.temperatureSignal = this.establishState(signal);
        System.out.println("Temperature Sensor state changes to " + signal + " (" + this.units + ")");
        this.notifyObservers();
    }
}

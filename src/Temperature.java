public class Temperature extends Observable {

    public Temperature(){
        this.state = false;
        this.units = null;
    }

    @Override
    public boolean getState(){
        return this.state;
    }

    @Override
    public void setUnits(String units) {
        this.units = units;
    }

    @Override
    public String getUnits() {
        return this.units;
    }

    private Integer convertToC(Integer temperature){
        int result = (temperature - 32)*5/9;
        return result;
    }

    @Override
    public boolean verifyState(String signal){
        boolean actualState = false;
        try {
            int sensorSignal = Integer.parseInt(signal);
            int temperature = sensorSignal;
            String units = this.units;
            if ("celsius".equals(units) || "fahrenheit".equals(units)) {
                if ("fahrenheit".equals(this.units)) {
                    temperature = this.convertToC(sensorSignal);
                }
                if (temperature <= 0 && temperature <= 20) {
                    actualState = false;
                } else if (temperature > 20) {
                    actualState = true;
                }
            }
        }catch (NumberFormatException e){
            System.out.println("The sensor state: "+ signal +" is not valid. The devices won't be notified.");
        }finally {
            return actualState;
        }
    }

    @Override
    public void setState(String signal){
        this.state = this.verifyState(signal);
        System.out.println("Temperature Sensor state changes to " + signal + " (" + this.units + ")");
        this.notifyObservers();
    }
}

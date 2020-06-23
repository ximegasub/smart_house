public class Movement extends Observable {
    private String moveDetected;
    private String units;

    public Movement(){
        this.moveDetected = "false";
        this.units = null;
    }

    @Override
    public String getState(){
        return this.moveDetected;
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
    public void setState(String state){
        this.moveDetected = state;
        System.out.println("Movement sensor state changes to " + this.moveDetected);
        this.notifyObservers();
    }

}

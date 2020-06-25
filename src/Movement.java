public class Movement extends Observable {
    private boolean moveDetected;
    private String units;

    public Movement(){
        this.moveDetected = false;
        this.units = null;
    }

    @Override
    public boolean getState(){
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

    public boolean establishState(String state){
        boolean actualState = false;
        if ("on".equals(state)){
            actualState = true;
        }else if("off".equals(state)){
            actualState = false;
        }else{
            System.out.println("The sensor state: "+ state +" is not valid. The devices won't be notified.");
        }
        return actualState;
    }

    @Override
    public void setState(String state){
        this.moveDetected = this.establishState(state);
        System.out.println("Movement sensor state changes to " + state);
        this.notifyObservers();
    }

}

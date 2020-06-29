public class Cinema extends Observable {

    public Cinema(){
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

    @Override
    public boolean verifyState(String state){
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
        this.state = this.verifyState(state);
        System.out.println("Cinema sensor state changes to " + state);
        this.notifyObservers();
    }

}


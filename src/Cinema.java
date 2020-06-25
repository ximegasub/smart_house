public class Cinema extends Observable {
    private boolean cinemaActive;
    private String units;

    public Cinema(){
        this.cinemaActive = false;
        this.units = null;
    }

    @Override
    public boolean getState(){
        return this.cinemaActive;
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
            System.out.println("The sensor state: "+ state +" is not valid. The devices won't be activated.");
        }
        return actualState;
    }

    @Override
    public void setState(String state){
        this.cinemaActive = this.establishState(state);
        System.out.println("Cinema sensor state changes to " + this.cinemaActive);
        this.notifyObservers();
    }

}


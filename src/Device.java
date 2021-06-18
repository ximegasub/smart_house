public abstract class Device {
    protected boolean deviceOn;
    protected String place;
    protected Observable observable;

    public boolean getDeviceOn(){
        return this.deviceOn;
    }

    public String getPlace(){
        return this.place;
    }

    protected void deviceOn(String message){
        System.out.println(message);
        deviceOn = true;
    }

    protected void deviceOff(String message){
        System.out.println(message);
        deviceOn = false;
    }
}

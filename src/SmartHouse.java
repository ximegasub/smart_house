import java.io.File;
import java.util.Scanner;

public class SmartHouse {
    public static void main(String args[]) {
        Observable sensor = new Movement();
        Light lights = new Light(sensor, "bedroom");
        Camera camera = new Camera(sensor, "front door");
//        sensor.deactivate(lights);
        sensor.setState("true");
    }
}


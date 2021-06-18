import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestLight {

    private Light light;

    @Before
    public void setUp() {
        light = new Light();
    }

    @Test
    public void testUpdateOn() {
        Observable movement = new Movement();
        light.definePlace("bedroom");
        light.defineObservable(movement);
        movement.setState("on");
        assertTrue(light.getDeviceOn());
    }

    @Test
    public void testUpdateOff() {
        Observable movement = new Movement();
        light.definePlace("bedroom");
        light.defineObservable(movement);
        movement.setState("off");
        assertFalse(light.getDeviceOn());
    }
}


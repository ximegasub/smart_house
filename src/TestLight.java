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
        movement.setState("on");
        light.definePlace("bedroom");
        light.defineObservable(movement);
        light.update();
        assertTrue(light.getLightOn());
    }

    @Test
    public void testUpdateOff() {
        Observable movement = new Movement();
        movement.setState("off");
        light.definePlace("bedroom");
        light.defineObservable(movement);
        light.update();
        assertFalse(light.getLightOn());
    }
}


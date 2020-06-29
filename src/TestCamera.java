import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestCamera {

    private Camera camera;

    @Before
    public void setUp() {
        camera = new Camera();
    }

    @Test
    public void testUpdateOn() {
        Observable movement = new Movement();
        camera.definePlace("bedroom");
        camera.defineObservable(movement);
        movement.setState("on");
        assertTrue(camera.getDeviceOn());
    }

    @Test
    public void testUpdateOff() {
        Observable movement = new Movement();
        camera.definePlace("bedroom");
        camera.defineObservable(movement);
        movement.setState("off");
        assertFalse(camera.getDeviceOn());
    }
}

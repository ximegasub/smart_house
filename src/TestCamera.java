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
        movement.setState("on");
        camera.definePlace("bedroom");
        camera.defineObservable(movement);
        camera.update();
        assertTrue(camera.getCameraOn());
    }

    @Test
    public void testUpdateOff() {
        Observable movement = new Movement();
        movement.setState("off");
        camera.definePlace("bedroom");
        camera.defineObservable(movement);
        camera.update();
        assertFalse(camera.getCameraOn());
    }
}

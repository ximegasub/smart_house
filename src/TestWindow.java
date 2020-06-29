import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestWindow {

    private  Window window;

    @Before
    public void setUp() {
        window = new Window();
    }

    @Test
    public void testUpdateTemperatureOn() {
        Observable temperature = new Temperature();
        window.definePlace("bedroom");
        window.defineObservable(temperature);
        temperature.setState("50");
        temperature.setUnits("celsius");
        assertTrue(window.getDeviceOn());
    }

    @Test
    public void testUpdateCinemaOn() {
        Observable cinema = new Cinema();
        window.definePlace("bedroom");
        window.defineObservable(cinema);
        cinema.setState("on");
        assertFalse(window.getDeviceOn());
    }

    @Test
    public void testUpdateTemperatureOff() {
        Observable temperature = new Temperature();
        window.definePlace("bedroom");
        window.defineObservable(temperature);
        temperature.setUnits("celsius");
        temperature.setState("10");
        assertFalse(window.getDeviceOn());
    }

    @Test
    public void testUpdateCinemaOff() {
        Observable cinema = new Cinema();
        window.definePlace("bedroom");
        window.defineObservable(cinema);
        cinema.setState("off");
        assertTrue(window.getDeviceOn());
    }
}

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
        temperature.setUnits("celsius");
        temperature.setState("50");
        window.definePlace("bedroom");
        window.defineObservable(temperature);
        window.update();
        assertTrue(window.getIsOpen());
    }

    @Test
    public void testUpdateCinemaOn() {
        Observable cinema = new Cinema();
        cinema.setState("on");
        window.definePlace("bedroom");
        window.defineObservable(cinema);
        window.update();
        assertFalse(window.getIsOpen());
    }

    @Test
    public void testUpdateTemperatureOff() {
        Observable temperature = new Temperature();
        temperature.setUnits("celsius");
        temperature.setState("10");
        window.definePlace("bedroom");
        window.defineObservable(temperature);
        window.update();
        assertFalse(window.getIsOpen());
    }

    @Test
    public void testUpdateCinemaOff() {
        Observable cinema = new Cinema();
        cinema.setState("off");
        window.definePlace("bedroom");
        window.defineObservable(cinema);
        window.update();
        assertTrue(window.getIsOpen());
    }
}

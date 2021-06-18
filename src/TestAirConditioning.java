import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestAirConditioning {

    private AirConditioning air;

    @Before
    public void setUp() {
        air = new AirConditioning();
    }

    @Test
    public void testUpdateOn() {
        Observable temperature = new Temperature();
        temperature.setState("50");
        air.definePlace("bedroom");
        air.defineObservable(temperature);
        temperature.setUnits("celsius");
        assertTrue(air.getDeviceOn());
    }

    @Test
    public void testUpdateOff() {
        Observable temperature = new Temperature();
        temperature.setState("10");
        air.definePlace("bedroom");
        air.defineObservable(temperature);
        temperature.setUnits("celsius");
        assertFalse(air.getDeviceOn());
    }
}



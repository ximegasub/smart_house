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
        temperature.setUnits("celsius");
        temperature.setState("50");
        air.definePlace("bedroom");
        air.defineObservable(temperature);
        air.update();
        assertTrue(air.getAirOn());
    }

    @Test
    public void testUpdateOff() {
        Observable temperature = new Temperature();
        temperature.setUnits("celsius");
        temperature.setState("10");
        air.definePlace("bedroom");
        air.defineObservable(temperature);
        air.update();
        assertFalse(air.getAirOn());
    }
}



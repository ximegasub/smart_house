import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestTemperature {

    private Temperature temperature;

    @Before
    public void setUp() {
        temperature = new Temperature();
    }

    @Test
    public void testEstablishWrongState() {
        temperature.setUnits("celsius");
        String state = "hola";
        boolean actual_state = temperature.verifyState(state);
        assertFalse(actual_state);
    }

    @Test
    public void testEstablishCorrectState() {
        temperature.setUnits("fahrenheit");
        String state = "140";
        boolean actual_state = temperature.verifyState(state);
        assertTrue(actual_state);
    }

    @Test
    public void testEstablishEmptyState() {
        temperature.setUnits("");
        String state = "";
        boolean actual_state = temperature.verifyState(state);
        assertFalse(actual_state);
    }
}

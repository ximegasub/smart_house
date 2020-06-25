import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestCinema {

    private Cinema cinema;

    @Before
    public void setUp() {
        cinema = new Cinema();
    }

    @Test
    public void testEstablishWrongState() {
        String state = "hola";
        boolean actual_state = cinema.establishState(state);
        assertFalse(actual_state);
    }

    @Test
    public void testEstablishCorrectState() {
        String state = "on";
        boolean actual_state = cinema.establishState(state);
        assertTrue(actual_state);
    }

    @Test
    public void testEstablishEmptyState() {
        String state = "";
        boolean actual_state = cinema.establishState(state);
        assertFalse(actual_state);
    }
}


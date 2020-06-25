import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestMovement {

    private Movement movement;

    @Before
    public void setUp() {
        movement = new Movement();
    }

    @Test
    public void testEstablishWrongState() {
        String state = "hola";
        boolean actual_state = movement.establishState(state);
        assertFalse(actual_state);
    }

    @Test
    public void testEstablishCorrectState() {
        String state = "on";
        boolean actual_state = movement.establishState(state);
        assertTrue(actual_state);
    }

    @Test
    public void testEstablishEmptyState() {
        String state = "";
        boolean actual_state = movement.establishState(state);
        assertFalse(actual_state);
    }
}


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestTelevision {

    private  Television television;

    @Before
    public void setUp() {
        television = new Television();
    }

    @Test
    public void testUpdateOn() {
        Observable cinema = new Cinema();
        cinema.setState("on");
        television.definePlace("bedroom");
        television.defineObservable(cinema);
        television.update();
        assertTrue(television.getDeviceOn());
    }

    @Test
    public void testUpdateOff() {
        Observable cinema = new Cinema();
        cinema.setState("off");
        television.definePlace("bedroom");
        television.defineObservable(cinema);
        television.update();
        assertFalse(television.getDeviceOn());
    }
}



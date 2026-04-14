package academy.tochkavhoda.misc.v3;

import academy.tochkavhoda.colors.v3.Color;
import academy.tochkavhoda.colors.v3.ColorException;
import academy.tochkavhoda.figures.v3.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBalloon {
    private static final double EPS = 1e-6;

    @Test
    public void testMoveResizeAndArea() throws ColorException {
        Balloon balloon = new Balloon(0, 0, 10, Color.GREEN);
        balloon.moveTo(new Point(5, 5));
        balloon.resize(0.5);
        assertEquals(new Point(5, 5), balloon.getCenter());
        assertEquals(5, balloon.getRadius());
        assertEquals(Math.PI * 25, balloon.getArea(), EPS);
    }

    @Test
    public void testSetColorByString() throws ColorException {
        Balloon balloon = new Balloon(new Point(1, 2), 3, "GREEN");
        balloon.setColor("BLUE");
        assertEquals(Color.BLUE, balloon.getColor());
    }

    @Test
    public void testEqualsAndHashCode() throws ColorException {
        Balloon balloon1 = new Balloon(new Point(1, 2), 3, Color.GREEN);
        Balloon balloon2 = new Balloon(new Point(1, 2), 3, "GREEN");
        Balloon balloon3 = new Balloon(new Point(1, 2), 4, Color.GREEN);
        assertEquals(balloon1, balloon2);
        assertEquals(balloon1.hashCode(), balloon2.hashCode());
        assertNotEquals(balloon1, balloon3);
    }
}

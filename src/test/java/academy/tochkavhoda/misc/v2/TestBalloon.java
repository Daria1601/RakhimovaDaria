package academy.tochkavhoda.misc.v2;

import academy.tochkavhoda.figures.v2.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestBalloon {
    private static final double EPS = 1e-6;

    @Test
    public void testMoveResizeAndArea() {
        Balloon balloon = new Balloon(0, 0, 10, 1);
        balloon.moveTo(new Point(5, 5));
        balloon.resize(0.5);
        assertEquals(new Point(5, 5), balloon.getCenter());
        assertEquals(5, balloon.getRadius());
        assertEquals(Math.PI * 25, balloon.getArea(), EPS);
    }

    @Test
    public void testEqualsAndHashCode() {
        Balloon balloon1 = new Balloon(new Point(1, 2), 3, 4);
        Balloon balloon2 = new Balloon(new Point(1, 2), 3, 4);
        Balloon balloon3 = new Balloon(new Point(1, 2), 4, 4);
        assertEquals(balloon1, balloon2);
        assertEquals(balloon1.hashCode(), balloon2.hashCode());
        assertNotEquals(balloon1, balloon3);
    }
}

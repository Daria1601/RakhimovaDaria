package academy.tochkavhoda.misc.v2;

import academy.tochkavhoda.figures.v2.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestPaletteMarker {
    @Test
    public void testMoveAndColor() {
        PaletteMarker marker = new PaletteMarker(10, 20, 3);
        marker.moveRel(5, -10);
        marker.setColor(7);
        assertEquals(new Point(15, 10), marker.getPosition());
        assertEquals(7, marker.getColor());
    }

    @Test
    public void testEqualsAndHashCode() {
        PaletteMarker marker1 = new PaletteMarker(new Point(1, 2), 3);
        PaletteMarker marker2 = new PaletteMarker(new Point(1, 2), 3);
        PaletteMarker marker3 = new PaletteMarker(new Point(1, 2), 4);
        assertEquals(marker1, marker2);
        assertEquals(marker1.hashCode(), marker2.hashCode());
        assertNotEquals(marker1, marker3);
    }
}

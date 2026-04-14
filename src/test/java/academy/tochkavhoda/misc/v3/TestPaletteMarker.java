package academy.tochkavhoda.misc.v3;

import academy.tochkavhoda.colors.v3.Color;
import academy.tochkavhoda.colors.v3.ColorErrorCode;
import academy.tochkavhoda.colors.v3.ColorException;
import academy.tochkavhoda.figures.v3.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPaletteMarker {
    @Test
    public void testMoveAndColor() throws ColorException {
        PaletteMarker marker = new PaletteMarker(10, 20, Color.GREEN);
        marker.moveRel(5, -10);
        marker.setColor("BLUE");
        assertEquals(new Point(15, 10), marker.getPosition());
        assertEquals(Color.BLUE, marker.getColor());
    }

    @Test
    public void testWrongColorData() throws ColorException {
        assertEquals(ColorErrorCode.NULL_COLOR,
                assertThrows(ColorException.class, () -> new PaletteMarker(1, 2, (Color) null)).getErrorCode());
        assertEquals(ColorErrorCode.WRONG_COLOR_STRING,
                assertThrows(ColorException.class, () -> new PaletteMarker(1, 2, "YELLOW")).getErrorCode());
    }

    @Test
    public void testEqualsAndHashCode() throws ColorException {
        PaletteMarker marker1 = new PaletteMarker(new Point(1, 2), "GREEN");
        PaletteMarker marker2 = new PaletteMarker(new Point(1, 2), Color.GREEN);
        PaletteMarker marker3 = new PaletteMarker(new Point(1, 2), Color.BLUE);
        assertEquals(marker1, marker2);
        assertEquals(marker1.hashCode(), marker2.hashCode());
        assertNotEquals(marker1, marker3);
    }
}

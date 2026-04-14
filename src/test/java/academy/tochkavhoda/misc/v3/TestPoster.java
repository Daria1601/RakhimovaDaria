package academy.tochkavhoda.misc.v3;

import academy.tochkavhoda.colors.v3.Color;
import academy.tochkavhoda.colors.v3.ColorErrorCode;
import academy.tochkavhoda.colors.v3.ColorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPoster {
    @Test
    public void testAreaAndColor() throws ColorException {
        Poster poster = new Poster(20, 10, "GREEN");
        assertEquals(200.0, poster.getArea());
        assertEquals(Color.GREEN, poster.getColor());
        poster.setColor(Color.BLUE);
        assertEquals(Color.BLUE, poster.getColor());
    }

    @Test
    public void testNullColor() throws ColorException {
        Poster poster = new Poster(2, 3, Color.RED);
        assertEquals(ColorErrorCode.NULL_COLOR,
                assertThrows(ColorException.class, () -> poster.setColor((Color) null)).getErrorCode());
    }

    @Test
    public void testEqualsAndHashCode() throws ColorException {
        Poster poster1 = new Poster(2, 3, Color.GREEN);
        Poster poster2 = new Poster(2, 3, "GREEN");
        Poster poster3 = new Poster(2, 3, Color.BLUE);
        assertEquals(poster1, poster2);
        assertEquals(poster1.hashCode(), poster2.hashCode());
        assertNotEquals(poster1, poster3);
    }
}

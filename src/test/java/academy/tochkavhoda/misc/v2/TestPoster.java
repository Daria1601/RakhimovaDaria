package academy.tochkavhoda.misc.v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestPoster {
    @Test
    public void testAreaAndColor() {
        Poster poster = new Poster(20, 10, 2);
        assertEquals(200.0, poster.getArea());
        assertEquals(2, poster.getColor());
        poster.setColor(5);
        assertEquals(5, poster.getColor());
    }

    @Test
    public void testEqualsAndHashCode() {
        Poster poster1 = new Poster(2, 3, 4);
        Poster poster2 = new Poster(2, 3, 4);
        Poster poster3 = new Poster(2, 3, 5);
        assertEquals(poster1, poster2);
        assertEquals(poster1.hashCode(), poster2.hashCode());
        assertNotEquals(poster1, poster3);
    }
}

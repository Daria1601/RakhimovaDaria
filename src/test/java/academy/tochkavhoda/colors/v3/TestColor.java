package academy.tochkavhoda.colors.v3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestColor {
    @Test
    public void testColorFromString() throws ColorException {
        assertEquals(Color.RED, Color.colorFromString("RED"));
        assertEquals(Color.GREEN, Color.colorFromString("GREEN"));
        assertEquals(Color.BLUE, Color.colorFromString("BLUE"));
    }

    @Test
    public void testColorFromStringErrors() {
        ColorException wrong = assertThrows(ColorException.class, () -> Color.colorFromString("YELLOW"));
        assertEquals(ColorErrorCode.WRONG_COLOR_STRING, wrong.getErrorCode());
        ColorException nullColor = assertThrows(ColorException.class, () -> Color.colorFromString(null));
        assertEquals(ColorErrorCode.NULL_COLOR, nullColor.getErrorCode());
    }
}

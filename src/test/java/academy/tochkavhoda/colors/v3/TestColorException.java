package academy.tochkavhoda.colors.v3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestColorException {
    @Test
    public void testErrorCodeAndMessage() {
        ColorException exception = new ColorException(ColorErrorCode.NULL_COLOR);
        assertEquals(ColorErrorCode.NULL_COLOR, exception.getErrorCode());
        assertEquals("Color is null", exception.getMessage());
        assertEquals("Wrong color string", ColorErrorCode.WRONG_COLOR_STRING.getErrorString());
    }
}

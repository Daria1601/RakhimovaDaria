package academy.tochkavhoda.misc.v2;

import academy.tochkavhoda.figures.v2.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestTextLabel {
    @Test
    public void testMoveAndSetters() {
        TextLabel label = new TextLabel(1, 2, "old");
        label.moveRel(4, 5);
        label.setText("new");
        assertEquals(new Point(5, 7), label.getAnchor());
        assertEquals("new", label.getText());
    }

    @Test
    public void testEqualsAndHashCode() {
        TextLabel label1 = new TextLabel(new Point(1, 2), "a");
        TextLabel label2 = new TextLabel(new Point(1, 2), "a");
        TextLabel label3 = new TextLabel(new Point(1, 2), "b");
        assertEquals(label1, label2);
        assertEquals(label1.hashCode(), label2.hashCode());
        assertNotEquals(label1, label3);
    }
}

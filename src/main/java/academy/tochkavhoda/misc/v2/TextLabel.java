package academy.tochkavhoda.misc.v2;

import academy.tochkavhoda.figures.v2.Point;
import academy.tochkavhoda.iface.v2.Movable;

import java.util.Objects;

public class TextLabel implements Movable {
    private Point anchor;
    private String text;

    public TextLabel(Point anchor, String text) {
        this.anchor = anchor;
        this.text = text;
    }

    public TextLabel(int x, int y, String text) {
        this(new Point(x, y), text);
    }

    public Point getAnchor() {
        return anchor;
    }

    public void setAnchor(Point anchor) {
        this.anchor = anchor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void moveTo(int x, int y) {
        this.anchor = new Point(x, y);
    }

    @Override
    public void moveRel(int dx, int dy) {
        this.anchor = new Point(anchor.getX() + dx, anchor.getY() + dy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TextLabel textLabel = (TextLabel) o;
        return Objects.equals(anchor, textLabel.anchor) && Objects.equals(text, textLabel.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(anchor, text);
    }
}

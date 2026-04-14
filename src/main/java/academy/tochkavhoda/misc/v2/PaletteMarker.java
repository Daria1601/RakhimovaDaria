package academy.tochkavhoda.misc.v2;

import academy.tochkavhoda.figures.v2.Point;
import academy.tochkavhoda.iface.v2.Colored;
import academy.tochkavhoda.iface.v2.Movable;

import java.util.Objects;

public class PaletteMarker implements Movable, Colored {
    private Point position;
    private int color;

    public PaletteMarker(Point position, int color) {
        this.position = position;
        this.color = color;
    }

    public PaletteMarker(int x, int y, int color) {
        this(new Point(x, y), color);
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public void moveTo(int x, int y) {
        this.position = new Point(x, y);
    }

    @Override
    public void moveRel(int dx, int dy) {
        this.position = new Point(position.getX() + dx, position.getY() + dy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PaletteMarker that = (PaletteMarker) o;
        return color == that.color && Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, color);
    }
}

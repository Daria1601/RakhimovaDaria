package academy.tochkavhoda.misc.v3;

import academy.tochkavhoda.colors.v3.Color;
import academy.tochkavhoda.colors.v3.ColorErrorCode;
import academy.tochkavhoda.colors.v3.ColorException;
import academy.tochkavhoda.figures.v3.Point;
import academy.tochkavhoda.iface.v3.Colored;
import academy.tochkavhoda.iface.v3.Movable;

import java.util.Objects;

public class PaletteMarker implements Movable, Colored {
    private Point position;
    private Color color;

    public PaletteMarker(Point position, Color color) throws ColorException {
        this.position = position;
        setColor(color);
    }

    public PaletteMarker(Point position, String colorString) throws ColorException {
        this(position, Color.colorFromString(colorString));
    }

    public PaletteMarker(int x, int y, Color color) throws ColorException {
        this(new Point(x, y), color);
    }

    public PaletteMarker(int x, int y, String colorString) throws ColorException {
        this(x, y, Color.colorFromString(colorString));
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) throws ColorException {
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;
    }

    @Override
    public void setColor(String colorString) throws ColorException {
        setColor(Color.colorFromString(colorString));
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaletteMarker that = (PaletteMarker) o;
        return Objects.equals(position, that.position) && color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, color);
    }
}

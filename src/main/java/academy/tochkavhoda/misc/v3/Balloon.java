package academy.tochkavhoda.misc.v3;

import academy.tochkavhoda.colors.v3.Color;
import academy.tochkavhoda.colors.v3.ColorErrorCode;
import academy.tochkavhoda.colors.v3.ColorException;
import academy.tochkavhoda.figures.v3.Point;
import academy.tochkavhoda.iface.v3.Colored;
import academy.tochkavhoda.iface.v3.HasArea;
import academy.tochkavhoda.iface.v3.Movable;
import academy.tochkavhoda.iface.v3.Resizable;

import java.util.Objects;

public class Balloon implements Movable, Resizable, HasArea, Colored {
    private Point center;
    private int radius;
    private Color color;

    public Balloon(Point center, int radius, Color color) throws ColorException {
        this.center = center;
        this.radius = radius;
        setColor(color);
    }

    public Balloon(Point center, int radius, String colorString) throws ColorException {
        this(center, radius, Color.colorFromString(colorString));
    }

    public Balloon(int x, int y, int radius, Color color) throws ColorException {
        this(new Point(x, y), radius, color);
    }

    public Balloon(int x, int y, int radius, String colorString) throws ColorException {
        this(x, y, radius, Color.colorFromString(colorString));
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
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
        this.center = new Point(x, y);
    }

    @Override
    public void moveRel(int dx, int dy) {
        this.center = new Point(center.getX() + dx, center.getY() + dy);
    }

    @Override
    public void resize(double ratio) {
        this.radius = (int) (radius * ratio);
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balloon balloon = (Balloon) o;
        return radius == balloon.radius && Objects.equals(center, balloon.center) && color == balloon.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius, color);
    }
}

package academy.tochkavhoda.misc.v3;

import academy.tochkavhoda.colors.v3.Color;
import academy.tochkavhoda.colors.v3.ColorErrorCode;
import academy.tochkavhoda.colors.v3.ColorException;
import academy.tochkavhoda.iface.v3.Colored;
import academy.tochkavhoda.iface.v3.HasArea;

import java.util.Objects;

public class Poster implements HasArea, Colored {
    private int width;
    private int height;
    private Color color;

    public Poster(int width, int height, Color color) throws ColorException {
        this.width = width;
        this.height = height;
        setColor(color);
    }

    public Poster(int width, int height, String colorString) throws ColorException {
        this(width, height, Color.colorFromString(colorString));
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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
    public Color getColor() {
        return color;
    }

    @Override
    public double getArea() {
        return (double) width * height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Poster poster = (Poster) o;
        return width == poster.width && height == poster.height && color == poster.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height, color);
    }
}

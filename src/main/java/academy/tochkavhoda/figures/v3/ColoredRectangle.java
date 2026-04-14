package academy.tochkavhoda.figures.v3;

import academy.tochkavhoda.colors.v3.Color;
import academy.tochkavhoda.colors.v3.ColorErrorCode;
import academy.tochkavhoda.colors.v3.ColorException;
import academy.tochkavhoda.iface.v3.Colored;

import java.util.Objects;

public class ColoredRectangle extends Rectangle implements Colored {
    private Color color;

    public ColoredRectangle(Point topLeft, Point bottomRight, Color color) throws ColorException {
        super(topLeft, bottomRight);
        setColor(color);
    }

    public ColoredRectangle(Point topLeft, Point bottomRight, String colorString) throws ColorException {
        this(topLeft, bottomRight, Color.colorFromString(colorString));
    }

    public ColoredRectangle(int xLeft, int yTop, int xRight, int yBottom, Color color) throws ColorException {
        super(xLeft, yTop, xRight, yBottom);
        setColor(color);
    }

    public ColoredRectangle(int xLeft, int yTop, int xRight, int yBottom, String colorString) throws ColorException {
        this(xLeft, yTop, xRight, yBottom, Color.colorFromString(colorString));
    }

    public ColoredRectangle(int length, int width, Color color) throws ColorException {
        super(length, width);
        setColor(color);
    }

    public ColoredRectangle(int length, int width, String colorString) throws ColorException {
        this(length, width, Color.colorFromString(colorString));
    }

    public ColoredRectangle(Color color) throws ColorException {
        super();
        setColor(color);
    }

    public ColoredRectangle(String colorString) throws ColorException {
        this(Color.colorFromString(colorString));
    }

    public ColoredRectangle() throws ColorException {
        this(Color.RED);
    }

    @Override
    public Color getColor() {
        return this.color;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ColoredRectangle that)) return false;
        return color == that.color &&
                Objects.equals(getTopLeft(), that.getTopLeft()) &&
                Objects.equals(getBottomRight(), that.getBottomRight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTopLeft(), getBottomRight(), color);
    }
}

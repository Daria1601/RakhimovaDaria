package academy.tochkavhoda.figures.v2;

import academy.tochkavhoda.iface.v2.Colored;

import java.util.Objects;

public class ColoredRectangle extends Rectangle implements Colored {
    private int color;

    public ColoredRectangle(Point topLeft, Point bottomRight, int color) {
        super(topLeft, bottomRight);
        this.color = color;
    }

    public ColoredRectangle(int xLeft, int yTop, int xRight, int yBottom, int color) {
        super(xLeft, yTop, xRight, yBottom);
        this.color = color;
    }

    public ColoredRectangle(int length, int width, int color) {
        super(length, width);
        this.color = color;
    }

    public ColoredRectangle(int color) {
        super();
        this.color = color;
    }

    public ColoredRectangle() {
        this(1);
    }

    @Override
    public int getColor() {
        return this.color;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
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

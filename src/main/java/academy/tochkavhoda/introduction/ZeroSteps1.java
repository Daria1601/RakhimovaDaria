package academy.tochkavhoda.introduction;

import java.util.Arrays;

public class ZeroSteps1 {

    public int sum(int x, int y) {
        return x + y;
    }

    public int mul(int x, int y) {
        return x * y;
    }

    public int div(int x, int y) {
        if (y != 0) {
            return x / y;
        }

        System.out.println("Знаменатель не должен быть равен 0");
        return y;
    }

    public int mod(int x, int y) {
        return x % y;
    }

    public boolean isEqual(int x, int y) {
        return x == y;
    }

    public boolean isGreater(int x, int y) {
        return x > y;
    }

    public double calculateTriangleSquare(int side1, int side2) {
        return (double) (side1 * side2) / 2;
    }

    public double calculateTrianglePerimeter(int side1, int side2) {
        double powSide1 = Math.pow(side1, 2);
        double powSide2 = Math.pow(side2, 2);

        return Math.sqrt((powSide1 - powSide2)) + side1 + side2;
    }

    public int reverseNumber(int number) {
        int a = number / 100;
        int b = number / 10 % 10;
        int c = number % 10;
        return c * 100 + b * 10 + a;
    }

    public long calculate15Degree(int number) {
        return (long) Math.pow(number, 15);
    }

    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
        return (xLeft <= x && x <= xRight) && (yTop <= y && y <= yBottom);
    }

    public double sqrtAbs(int number) {
        return Math.sqrt(Math.abs(number));
    }

    public boolean isTriangleExist(int side1, int side2, int side3) {
        return side1 + side2 > side3 && side1 + side3 > side2 && side2 + side2 > side1;
    }

    public int getDigitsProduction(int number) {
        int[] numbersArr = {number / 1000, (number / 100) % 10, (number / 10) % 10, number % 10};

        return numbersArr[0] * numbersArr[1] * numbersArr[2] * numbersArr[3];
    }

    public boolean isCircleInsideSquare(int radius, int side) {
        return (2 * radius) < side;
    }

    public char getCharByCode(short code) {
        return (char) code;
    }

    public short getCodeByChar(char character) {
        return (short) character;
    }

    public char getCharByCodeAndOffset(char ch, short offset) {
        short code = (short) ch;
        return (char) (code + offset);
    }

    public boolean isGreaterOrEqual(char ch1, char ch2) {
        short[] codesArr = {(short) ch1, (short) ch2};
        return codesArr[0] > codesArr[1] || codesArr[0] == codesArr[1];
    }

    public char getAverageChar(char ch1, char ch2) {
        short code1 = (short) ch1;
        short code2 = (short) ch2;
        short resCode = (short) ((code1 + code2) / 2.0);
        return (char) resCode;
    }
}

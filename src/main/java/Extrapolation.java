import java.util.List;

public class Extrapolation {
    private final List<Double> x;
    private final List<Double> y;

    public Extrapolation(List<Double> x, List<Double> y) {
        this.x = x;
        this.y = y;
    }

    public double getX(List<Double> x) {
        double rawX = 0.0;
        for (double xi : x) {
            rawX = rawX + xi;
        }
        return rawX;
    }

    public double getY(List<Double> y) {
        double rawY = 0.0;
        for (double yi : y) {
            rawY = rawY + yi;
        }
        return rawY;
    }

    public double getFunction(double rawX, double rawY,
                              double x1, double y1) {
        double valueX = x1 - rawX;
        double valueY = y1 - rawY;
        double sqrX = Math.pow(valueX, 2);
        return ((valueX * valueY) / sqrX);
    }

    public double getYPos(double rawX, double rawY, double function) {
        return (rawY - (function * rawX));
    }

    public double extrapolate(double iteration) {
        double x1 = x.get(0);
        double y1 = y.get(0);
        double rawX = getX(x);
        double rawY = getY(y);
        double function = getFunction(rawX, rawY, x1, y1);
        double yPosition = getYPos(rawX, rawY, function);
        return ((function * iteration) + yPosition);
    }
}
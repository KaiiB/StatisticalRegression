import java.util.HashMap;
import java.util.Set;

public class Function {
    private HashMap<LinReg, String> data = new HashMap<>();
    private LinReg bestFunction = new LinReg();

    public Function(double[] x, double[] y) {
        data.put(new LinReg(x, y), "Linear");
        double[] y2 = new double[y.length];
        for (int i = 0; i < y2.length; i++) {
            y2[i] = Math.sqrt(y[i]);
        }
        data.put(new LinReg(x, y2), "Quadratic");
        double[] y3 = new double[y.length];
        for (int i = 0; i < y3.length; i++) {
            y3[i] = Math.cbrt(y[i]);
        }
        data.put(new LinReg(x, y3), "Cubic");
        double[] y4 = new double[y.length];
        for (int i = 0; i < y4.length; i++) {
            y4[i] = Math.sqrt(Math.sqrt(y[i]));
        }
        data.put(new LinReg(x, y4), "Quartic");
        double[] lny = new double[y.length];
        for (int i = 0; i < lny.length; i++) {
            lny[i] = Math.exp(y[i]);
        }
        data.put(new LinReg(x, lny), "Logmarithic");
        double[] ey = new double[y.length];
        for (int i = 0; i < ey.length; i++) {
            ey[i] = Math.log(y[i]);
        }
        data.put(new LinReg(x, ey), "Exponential");
        double[] yinv = new double[y.length];
        for (int i = 0; i < yinv.length; i++) {
            yinv[i] = 1 / y[i];
        }
        data.put(new LinReg(x, yinv), "Inverse");
        double[] siny = new double[y.length];
        for (int i = 0; i < siny.length; i++) {
            siny[i] = Math.asin(y[i]);
        }
        data.put(new LinReg(x, siny), "Sine");
        double[] cosy = new double[y.length];
        for (int i = 0; i < cosy.length; i++) {
            cosy[i] = Math.acos(y[i]);
        }
        data.put(new LinReg(x, cosy), "Cosine");
        double min = (double) Integer.MIN_VALUE;
        for (LinReg function : data.keySet()) {
            if (function.getR2() > min) {
                min = function.getR2();
                bestFunction = function;
            }
        }
    }

    public LinReg getBestFunction() {
        return bestFunction;
    }

    public String getBestFunctionName() {
        return "Best fit function: " + data.get(bestFunction);
    }
}
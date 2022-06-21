import java.lang.Math;

public class LinReg {
    private double xbar;
    private double ybar;
    private double Sx;
    private double Sy;
    private double r;
    private int n;
    private double a;
    private double b;
    private double r2;
    private double[] xvalues;
    private double[] yvalues;

    public LinReg() {
        n = 1;
    }

    public LinReg(double[] x, double[] y) {
        this.xvalues = x;
        this.yvalues = y;
        double sumx = 0;
        double sumy = 0;
        double sumxdiff = 0;
        double sumydiff = 0;
        if (x.length == y.length) {
            this.n = x.length;
        } else {
            System.out.println("Please enter a valid bivariable list.");
        }
        for (double i : x) {
            sumx += i;
            this.xbar = (sumx) / (x.length);
        }
        for (double j : y) {
            sumy += j;
            this.ybar = (sumy) / (y.length);
        }
        for (double i : x) {
            sumxdiff += (i - this.getXbar()) * (i - this.getXbar());
            Sx = Math.sqrt((sumxdiff) / (x.length - 1));
        }
        for (double j : y) {
            sumydiff += (j - this.getYbar()) * (j - this.getYbar());
            Sy = Math.sqrt((sumydiff) / (y.length - 1));
        }
        double rnum = 0;
        double rdenom = 0;
        for (int i = 0; i < n; i++) {
            double xysum = x[i] * y[i];
            rnum += xysum;
        }
        rnum = (rnum * n) - (sumx * sumy);
        for (double i : x) {
            rdenom += i * i;
        }
        rdenom = n * rdenom - (sumx) * (sumx);
        double ysquaredsum = 0;
        for (double j : y) {
            ysquaredsum += j * j;
        }
        rdenom *= (n * ysquaredsum) - (sumy * sumy);
        rdenom = Math.sqrt(rdenom);
        this.r = rnum / rdenom;
        this.b = r * (Sy / Sx);
        this.a = ybar - getB() * xbar;
        this.r2 = r * r;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getXbar() {
        return xbar;
    }

    public double getYbar() {
        return ybar;
    }

    public double getSx() {
        return Sx;
    }

    public double getSy() {
        return Sy;
    }

    public double getR() {
        return r;
    }

    public double getR2() {
        return r2;
    }

    public int getN() {
        return n;
    }

    public double[] getXValues() {
        return xvalues;
    }

    public double[] getYValues() {
        return yvalues;
    }

    public String getLRSL() {
        return "y = " + this.getB() + " *x + " + this.getA();
    }

    public String getSummaryStatistics() {
        String newLine = System.getProperty("line.separator");
        return String.join(newLine, "Correlation: " + this.getR(), "Coefficient of determination: " + this.getR2(),
                "Line of best fit: " + this.getLRSL(), "X mean: " + this.getXbar(), "Y mean: " + this.getYbar(),
                "X Standard Deviation: " + this.getSx(), "Y Standard Deviation: " + this.getSy(),
                "Sample size: " + this.getN());
    }

}
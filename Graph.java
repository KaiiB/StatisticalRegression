import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.*;

public class Graph extends JComponent {
    private double[] x;
    private double[] y;
    private int SCALE;

    public Graph(double[] x, double[] y, int SCALE) {
        this.x = x;
        this.y = y;
        this.SCALE = SCALE;
    }

    public void paintComponent(Graphics g) {
        int yorigin = this.getY();
        int xorigin = this.getX();
        int w = this.getWidth();
        int h = this.getHeight();

        Graphics2D g1 = (Graphics2D) g;
        g1.setStroke(new BasicStroke(2));
        g1.setColor(Color.black);
        g1.drawLine(0, h / 2, w, h / 2);
        g1.drawLine(w / 2, 0, w / 2, h);
        for (int i = 0; i <= w; i += 10) {
            g1.drawString("" + i, w / 2 + SCALE * i, h / 2 + 15);
        }
        for (int i = 0; i <= w; i += 10) {
            g1.drawString("" + i, w / 2 - 15, h / 2 + -1 * SCALE * i);
        }

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.red);
        for (int i = 0; i < x.length; i++) {
            g2.fillOval(w / 2 + SCALE * (int) x[i], h / 2 + SCALE * -1 * (int) y[i], 8, 8);
        }
        g2.drawString("Original function", w / 2 + 20, h / 2 - 20);

        Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(2));
        g3.setColor(Color.blue);

        Function function = new Function(x, y);
        LinReg bestFit = function.getBestFunction();
        double[] ty = bestFit.getYValues();
        double tslope = bestFit.getB();
        double tintercept = bestFit.getA();
        for (int i = 0; i < x.length; i++) {
            g3.fillOval(w / 2 + SCALE * (int) x[i], h / 2 + SCALE * -1 * (int) ty[i], 8, 8);
        }
        g3.drawString("Transformed function", w / 2 + 20, h / 2 + 20);
        Graphics2D g4 = (Graphics2D) g;
        g4.setStroke(new BasicStroke(3));
        g4.setColor(Color.green);

        g4.drawLine(w / 2 + ((SCALE * (int) getMin(x))),
                h / 2 + (-1 * (SCALE * (int) (tslope * getMin(x) + tintercept))),
                w / 2 + ((SCALE * (int) getMax(x))), h / 2 + (-1 * (SCALE * (int) (tslope * getMax(x) + tintercept))));

    }

    public double getMin(double[] arr) {
        double min = (double) Integer.MAX_VALUE;
        for (double i : arr) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    public double getMax(double[] arr) {
        double max = (double) Integer.MIN_VALUE;
        for (double i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

}

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.*;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sampsize = new Scanner(System.in);
        int n = 0;
        System.out.println("Enter sample size: ");
        try {
            n = Integer.valueOf(sampsize.nextLine());
        } catch (Exception e) {
            System.out.println("Please type a valid integer.");
            n = Integer.valueOf(sampsize.nextLine());
        }
        double[] xarr = new double[n];
        double[] yarr = new double[n];
        for (int i = 0; i < n; i++) {
            Scanner val = new Scanner(System.in);
            System.out.println("Enter x-value " + (i + 1) + ": ");
            xarr[i] = Integer.valueOf(val.nextLine());
        }
        for (int i = 0; i < n; i++) {
            Scanner val = new Scanner(System.in);
            System.out.println("Enter y-value " + (i + 1) + ": ");
            yarr[i] = Integer.valueOf(val.nextLine());
        }

        LinReg test = new LinReg(xarr, yarr);
        Function func = new Function(xarr, yarr);
        System.out.println(func.getBestFunctionName());
        System.out.println(func.getBestFunction().getSummaryStatistics());
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(1000, 1000));
        frame.setTitle("Graphs");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        Graph graphs = new Graph(xarr, yarr, 10);
        frame.add(graphs);
        frame.setVisible(true);

    }
}
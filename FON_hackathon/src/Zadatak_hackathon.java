import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import java.util.List;


public class Zadatak_hackathon extends JPanel{
    private static final int PREF_W = 700;
    private static final int PREF_H = PREF_W;
    private Path2D myPath = new Path2D.Double();
    private Point2D A;
    private Point2D B;
    private Point2D C;
    private List<MyPoint> listaPointa;
    private MyPoint curr;
    private Random random = new Random();
    private boolean start = false;

    public Zadatak_hackathon() {
        double firstX = (PREF_W / 2.0) * (1 - 1 / Math.sqrt(3));
        double firstY = 3.0 * PREF_H / 4.0;

        myPath.moveTo(firstX, firstY);
        myPath.lineTo(PREF_W - firstX, firstY);
        myPath.lineTo(PREF_W / 2.0, PREF_H / 4.0);
        myPath.closePath();

        A = new MyPoint(firstX, firstY);
        B = new MyPoint(PREF_W - firstX, firstY);
        C = new MyPoint(PREF_W / 2.0, PREF_H / 4.0);

        listaPointa = new ArrayList<>();
        MyPoint initial = new MyPoint(random.nextDouble(0, PREF_W), random.nextDouble(0, PREF_W));
        listaPointa.add(initial);
        curr = initial;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setStroke(new BasicStroke(1.5F));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.draw(myPath);

        for(MyPoint p : listaPointa)
            g2.draw(new Line2D.Double(p.getX(), p.getY(), p.getX(), p.getY()));
    }

    public void dottedTriangles(){
            generateNew();
            repaint();
    }

    private void generateNew(){
        int dice = random.nextInt(1, 7);
        double newX;
        double newY;
        MyPoint newPoint = null;

        switch (dice){
            case 1,2:
                newX = (A.getX() + curr.getX())/2;
                newY = (A.getY() + curr.getY())/2;
                newPoint = new MyPoint(newX, newY);
                listaPointa.add(newPoint);
                break;
            case 3,4:
                newX = (B.getX() + curr.getX())/2;
                newY = (B.getY() + curr.getY())/2;
                newPoint = new MyPoint(newX, newY);
                listaPointa.add(newPoint);
                break;
            case 5,6:
                newX = (C.getX() + curr.getX())/2;
                newY = (C.getY() + curr.getY())/2;
                newPoint = new MyPoint(newX, newY);
                listaPointa.add(newPoint);
                break;
        }
        if(newPoint != null)
            curr = newPoint;
    }


    private class MyPoint extends Point2D{
        double x;
         double y;

        public MyPoint(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public double getX() {
            return x;
        }

        @Override
        public double getY() {
            return y;
        }

        @Override
        public void setLocation(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

}

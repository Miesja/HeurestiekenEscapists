package com.company;

    import java.awt.Color;
    import java.awt.Graphics;
    import java.awt.Graphics2D;
    import javax.swing.JFrame;
    import javax.swing.JPanel;
    import javax.swing.SwingUtilities;

    class DrawPanel extends JPanel {



        private void doDrawing(Graphics g) {

            Graphics2D g2d = (Graphics2D) g;

            g2d.setColor(new Color(212, 212, 212));
            g2d.drawRect(10, 15, 90, 60);
            g2d.drawRect(130, 15, 90, 60);
            g2d.drawRect(250, 15, 90, 60);
            g2d.drawRect(10, 105, 90, 60);
            g2d.drawRect(130, 105, 90, 60);
            g2d.drawRect(250, 105, 90, 60);
            g2d.drawRect(10, 195, 90, 60);
            g2d.drawRect(130, 195, 90, 60);
            g2d.drawRect(250, 195, 90, 60);

            g2d.setColor(new Color(125, 167, 116));
            g2d.fillRect(10, 15, 90, 60);

            g2d.setColor(new Color(42, 179, 231));
            g2d.fillRect(130, 15, 90, 60);

            g2d.setColor(new Color(70, 67, 123));
            g2d.fillRect(250, 15, 90, 60);

            g2d.setColor(new Color(130, 100, 84));
            g2d.fillRect(10, 105, 90, 60);

            g2d.setColor(new Color(252, 211, 61));
            g2d.fillRect(130, 105, 90, 60);

            g2d.setColor(new Color(241, 98, 69));
            g2d.fillRect(250, 105, 90, 60);

            g2d.setColor(new Color(217, 146, 54));
            g2d.fillRect(10, 195, 90, 60);

            g2d.setColor(new Color(63, 121, 186));
            g2d.fillRect(130, 195, 90, 60);

            g2d.setColor(new Color(31, 21, 1));
            g2d.fillRect(250, 195, 90, 60);
        }

        @Override
        public void paintComponent(Graphics g) {

            super.paintComponent(g);
            doDrawing(g);
        }
    }

    public class GI extends JFrame {

        public GI() {
            initUI();
        }

        public final void initUI() {

            DrawPanel dpnl = new DrawPanel();
            add(dpnl);

            //setSize(360, 300);
            setTitle("Solution");
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }

        public static void run() {


            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    GI ex = new GI();
                    ex.setVisible(true);
                }
            });
        }
    }


    /*public void makeCanvas(){
        new Canvas();
    }

    //Maakt de tegels en plaatst ze op het canvas
    public void makeTiles(int x, int y, int width, int length){
        Point p = new Point(x*10, y*10);
        Dimension d= new Dimension(width*10, length*10);
        Rectangle tile= new Rectangle(p, d);
    } */

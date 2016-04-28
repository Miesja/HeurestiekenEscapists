package com.company;

    import java.awt.*;
    import javax.swing.JFrame;
    import javax.swing.JPanel;
    import javax.swing.SwingUtilities;

    class DrawPanel extends JPanel {


        private void doDrawing(Graphics g) {

            Graphics2D g2d = (Graphics2D) g;

            //g2d.setColor(new Color(212, 212, 212));

            if (GI.field != null) {

                int iLengte = GI.field.length;
                int jLengte = GI.field[1].length;

                int tileSize = 20;

                for (int i = 0; i < iLengte; i ++) {
                    for (int j = 0; j < jLengte; j ++) {
                        int x = i * tileSize;
                        int y = j* tileSize;
                        g2d.drawRect(x, y, tileSize, tileSize);

                        if (GI.field[i][j].equals(" a ")) {
                            g2d.setColor(new Color(100, 40, 100));
                            g2d.fillRect(x, y, tileSize, tileSize);
                        }
                        if (GI.field[i][j].equals(" b ")) {
                            g2d.setColor(new Color(78, 100, 180));
                            g2d.fillRect(x, y, tileSize, tileSize);
                        }
                        if (GI.field[i][j].equals(" c ")) {
                            g2d.setColor(new Color(50, 200, 100));
                            g2d.fillRect(x, y, tileSize, tileSize);
                        }
                        if (GI.field[i][j].equals(" d ")) {
                            g2d.setColor(new Color(200, 200, 100));
                            g2d.fillRect(x, y, tileSize, tileSize);
                        }
                        if (GI.field[i][j].equals(" e ")) {
                            g2d.setColor(new Color(100, 200, 200));
                            g2d.fillRect(x, y, tileSize, tileSize);
                        }
                        if (GI.field[i][j].equals(" f ")) {
                            g2d.setColor(new Color(150, 230, 100));
                            g2d.fillRect(x, y, tileSize, tileSize);
                        }
                        if (GI.field[i][j].equals(" g ")) {
                            g2d.setColor(new Color(50, 10, 210));
                            g2d.fillRect(x, y, tileSize, tileSize);
                        }
                        if (GI.field[i][j].equals(" h ")) {
                            g2d.setColor(new Color(200, 10, 200));
                            g2d.fillRect(x, y, tileSize, tileSize);
                        }
                        if (GI.field[i][j].equals(" i ")) {
                            g2d.setColor(new Color(200, 100, 10));
                            g2d.fillRect(x, y, tileSize, tileSize);
                        }
                        if (GI.field[i][j].equals(" j ")) {
                            g2d.setColor(new Color(50, 50, 60));
                            g2d.fillRect(x, y, tileSize, tileSize);
                        }
                        if (GI.field[i][j].equals(" k ")) {
                            g2d.setColor(new Color(200, 200, 200));
                            g2d.fillRect(x, y, tileSize, tileSize);
                        }
                        if (GI.field[i][j].equals(" l ")) {
                            g2d.setColor(new Color(100, 100, 150));
                            g2d.fillRect(x, y, tileSize, tileSize);
                        }
                        if (GI.field[i][j].equals(" m ")) {
                            g2d.setColor(new Color(0, 200, 250));
                            g2d.fillRect(x, y, tileSize, tileSize);
                        }
                        if (GI.field[i][j].equals(" n ")) {
                            g2d.setColor(new Color(100, 10, 200));
                            g2d.fillRect(x, y, tileSize, tileSize);
                        }
                        if (GI.field[i][j].equals(" o ")) {
                            g2d.setColor(new Color(200, 60, 160));
                            g2d.fillRect(x, y, tileSize, tileSize);
                        }
                        if (GI.field[i][j].equals(" p ")) {
                            g2d.setColor(new Color(200, 110, 40));
                            g2d.fillRect(x, y, tileSize, tileSize);
                        }
                        if (GI.field[i][j].equals(" q ")) {
                            g2d.setColor(new Color(30, 40, 100));
                            g2d.fillRect(x, y, tileSize, tileSize);
                        }
                        if (GI.field[i][j].equals(" r ")) {
                            g2d.setColor(new Color(10, 200, 10));
                            g2d.fillRect(x, y, tileSize, tileSize);
                        }
                        if (GI.field[i][j].equals(" s ")) {
                            g2d.setColor(new Color(170, 90, 150));
                            g2d.fillRect(x, y, tileSize, tileSize);
                        }
                        if (GI.field[i][j].equals(" t ")) {
                            g2d.setColor(new Color(250, 5, 80));
                            g2d.fillRect(x, y, tileSize, tileSize);
                        }



                    }

                }
            }




            /*g2d.drawRect(10, 15, 90, 60);
            g2d.drawRect(130, 15, 90, 60);
            g2d.drawRect(250, 15, 90, 60);
            g2d.drawRect(10, 105, 90, 60);
            g2d.drawRect(130, 105, 90, 60);
            g2d.drawRect(250, 105, 90, 60);
            g2d.drawRect(10, 195, 90, 60);
            g2d.drawRect(130, 195, 90, 60);
            g2d.drawRect(250, 195, 90, 60);


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
            g2d.fillRect(250, 195, 90, 60);*/

        }
        @Override
        public void paintComponent(Graphics g) {

            super.paintComponent(g);
            doDrawing(g);
        }
    }

    public class GI extends JFrame {

        static String[][] field;

        public GI() {
            initUI();
        }

        public final void initUI() {


            DrawPanel dpnl = new DrawPanel();
            add(dpnl);
            setSize(1000, 1000);

            setTitle("Solution");
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }

        public  void go() {


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

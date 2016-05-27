package com.company;

    import java.awt.*;
    import javax.swing.JFrame;
    import javax.swing.JPanel;
    import javax.swing.SwingUtilities;

    class DrawPanel extends JPanel {


        private void doDrawing(Graphics g) {

            Graphics2D g2d = (Graphics2D) g;

            if (GI.field != null) {

                int iLengte = GI.field.length;
                int jLengte = GI.field[1].length;

                int tileSize = 10;

                for (int i = 0; i < iLengte; i ++) {
                    for (int j = 0; j < jLengte; j ++) {
                        int x = i * tileSize;
                        int y = j* tileSize;
                        g2d.drawRect(x, y, tileSize, tileSize);

                        // Change the color of the tile, depending on which tile it is

                        if (GI.field[i][j].equals(" a ")) {
                            g2d.setColor(new Color(100, 40, 100));
                        }
                        if (GI.field[i][j].equals(" b ")) {
                            g2d.setColor(new Color(78, 100, 180));
                        }
                        if (GI.field[i][j].equals(" c ")) {
                            g2d.setColor(new Color(50, 200, 100));
                        }
                        if (GI.field[i][j].equals(" d ")) {
                            g2d.setColor(new Color(200, 200, 100));
                        }
                        if (GI.field[i][j].equals(" e ")) {
                            g2d.setColor(new Color(100, 200, 200));
                        }
                        if (GI.field[i][j].equals(" f ")) {
                            g2d.setColor(new Color(150, 230, 100));
                        }
                        if (GI.field[i][j].equals(" g ")) {
                            g2d.setColor(new Color(50, 10, 210));
                        }
                        if (GI.field[i][j].equals(" h ")) {
                            g2d.setColor(new Color(200, 10, 200));
                        }
                        if (GI.field[i][j].equals(" i ")) {
                            g2d.setColor(new Color(200, 100, 10));
                        }
                        if (GI.field[i][j].equals(" j ")) {
                            g2d.setColor(new Color(50, 50, 60));
                        }
                        if (GI.field[i][j].equals(" k ")) {
                            g2d.setColor(new Color(200, 200, 200));
                        }
                        if (GI.field[i][j].equals(" l ")) {
                            g2d.setColor(new Color(100, 100, 150));
                        }
                        if (GI.field[i][j].equals(" m ")) {
                            g2d.setColor(new Color(0, 200, 250));
                        }
                        if (GI.field[i][j].equals(" n ")) {
                            g2d.setColor(new Color(100, 10, 200));
                        }
                        if (GI.field[i][j].equals(" o ")) {
                            g2d.setColor(new Color(200, 60, 160));
                        }
                        if (GI.field[i][j].equals(" p ")) {
                            g2d.setColor(new Color(200, 110, 40));
                        }
                        if (GI.field[i][j].equals(" q ")) {
                            g2d.setColor(new Color(30, 40, 100));
                        }
                        if (GI.field[i][j].equals(" r ")) {
                            g2d.setColor(new Color(10, 200, 10));
                        }
                        if (GI.field[i][j].equals(" s ")) {
                            g2d.setColor(new Color(170, 90, 150));
                        }
                        if (GI.field[i][j].equals(" t ")) {
                            g2d.setColor(new Color(250, 5, 80));
                        }
                        if (GI.field[i][j].equals(" u ")) {
                            g2d.setColor(new Color(102, 255, 255));
                        }
                        if (GI.field[i][j].equals(" v ")) {
                            g2d.setColor(new Color(255, 204, 229));
                        }
                        if (GI.field[i][j].equals(" w ")) {
                            g2d.setColor(new Color(255, 255, 204));
                        }
                        if (GI.field[i][j].equals(" x ")) {
                            g2d.setColor(new Color(204, 255, 229));
                        }
                        if (GI.field[i][j].equals(" y ")) {
                            g2d.setColor(new Color(102, 0, 51));
                        }
                        if (GI.field[i][j].equals(" z ")) {
                            g2d.setColor(new Color(255, 255, 0));
                        }
                        if (GI.field[i][j].equals(" A ")) {
                            g2d.setColor(new Color(51, 0, 102));
                        }
                        if (GI.field[i][j].equals(" B ")) {
                            g2d.setColor(new Color(200, 100, 100));
                        }
                        if (GI.field[i][j].equals(" C ")) {
                            g2d.setColor(new Color(178, 102, 255));
                        }
                        if (GI.field[i][j].equals(" D ")) {
                            g2d.setColor(new Color(255, 255, 255));
                        }
                        g2d.fillRect(x, y, tileSize, tileSize);

                    }
                }
            }

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
            if(field!=null) {
                dpnl.setPreferredSize(new Dimension(field.length * 10, field[1].length * 10));
            }
            add(dpnl);
            pack();

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


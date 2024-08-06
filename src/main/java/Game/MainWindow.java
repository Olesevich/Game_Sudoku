package Game;

import javax.swing.*;

public class MainWindow {

    public static JFrame jf;
    public static final int WIDTH = 476;
    public static final int HIEGTH = 590;


    public MainWindow() {
        jf = new JFrame();
        jf.setTitle("Sudoku 9x9");
        jf.setSize(WIDTH, HIEGTH);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(null);
        jf.add(new StartWindow());
        jf.setLocationRelativeTo(null);
        jf.setResizable(true);
        jf.setVisible(true);

    }

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        new CreatingGameArray();
//        new Game();
        new MainWindow();
    }
}

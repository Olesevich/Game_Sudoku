package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePlay extends JPanel {


    public static JPanel panel;
    public static JPanel panel2;
    public static JPanel panel3;
    public int nubmer;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;
    private JButton btnNewButton_3;
    private JButton btnNewButton_4;
    private JButton btnNewButton_5;
    private JButton btnNewButton_6;
    private JButton btnNewButton_7;
    private JButton btnNewButton_8;
    private JButton btnNewButton_9;
    TimerLabel t1 = new TimerLabel();


    public GamePlay() {
        panel = new JPanel();
        panel2 = new JPanel(null);
        panel3 = new JPanel(null);
        MainWindow.jf.add(panel);
        MainWindow.jf.add(panel3);
        panel.setLayout(null);
        panel.setBounds(2, 24, 459, 459);
        panel3.setBounds(0,0,466,22);
        panel.setBackground(Color.BLACK);
        gameButtons(panel);
        menuButtons(panel3);
        dotGameButtons();
        panel3.add(t1);
        t1.setBounds(400,2,60,20);
        t1.setFont(new Font("Times New Roman", Font.BOLD, 18));
        t1.setForeground(Color.RED);
        panel.setVisible(true);
        panel3.setVisible(true);

    }

    public void menuButtons(final JPanel panel){
        JMenuBar menuBar = new JMenuBar();
        panel.add(menuBar);
        menuBar.setBounds(0, 0, 120, 22);

        JMenu mnNewMenu = new JMenu("Файл");
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("Новая игра");
        mnNewMenu.add(mntmNewMenuItem);
        mntmNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                MainWindow.jf.setVisible(false);
                MainWindow.start();
            }
        });

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Выход");
        mnNewMenu.add(mntmNewMenuItem_1);
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

        JMenu mnNewMenu_1 = new JMenu("Настройки");
        menuBar.add(mnNewMenu_1);

        JMenuItem mntmNewMenuItem_3 = new JMenuItem("Пауза");
        mnNewMenu_1.add(mntmNewMenuItem_3);
        mntmNewMenuItem_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t1.stopTimer();
                JOptionPane.showMessageDialog(null,"Пауза");
                t1.restartTimer();
            }
        });

        JMenuItem mntmNewMenuItem_2 = new JMenuItem("Автор");
        mnNewMenu_1.add(mntmNewMenuItem_2);
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Автор проекта Олесевич Александр Сергеевич");
            }
        });
        panel.repaint();
    }

    public void buttonListenerEvent(final JToggleButton but,  final int a, final int b){
        if(Game.arrGame[a][b] != 0){
            but.setEnabled(false);
        }
        but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(but.isSelected()){
                    panel2.setVisible(true);
                    fasleButtons();
                    dopButtenEvent(but, btnNewButton_1,"1",a ,b, 1);
                    dopButtenEvent(but, btnNewButton_2,"2",a ,b ,2);
                    dopButtenEvent(but, btnNewButton_3,"3", a ,b ,3);
                    dopButtenEvent(but, btnNewButton_4,"4", a , b, 4);
                    dopButtenEvent(but, btnNewButton_5,"5",a ,b, 5);
                    dopButtenEvent(but, btnNewButton_6,"6",a ,b ,6);
                    dopButtenEvent(but, btnNewButton_7,"7", a ,b ,7);
                    dopButtenEvent(but, btnNewButton_8,"8", a , b, 8);
                    dopButtenEvent(but, btnNewButton_9,"9", a , b, 9);
                }
                else {
                    panel2.setVisible(false);
                }
            }
        });
    }

    public void dopButtenEvent(final JToggleButton but, JButton but1, final String slovo, final int a, final int b, final int sost){
        but1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (but.isSelected()){
                    but.setText(slovo);
                    but.setSelected(false);
                    panel2.setVisible(false);
                    Game.arrGame[a][b] = sost;
                    Game.superProverkaNaWinner();
                    Game.proverkaNaFeil();
                }
            }
        });
    }

    public String perevodSIntegerVString(int a, int b){
        if(Game.arrGame[a][b] == 0){
            return " ";
        }
        else {
            return String.valueOf(Game.arrGame[a][b]);
        }
    }

    public void gameButtons(JPanel panel){
        for (int i = 0, l = 2; i < 9; i++, l += 50) {
            for (int j = 0, k =2; j < 9; j++,k +=50) {
                JToggleButton newButtons = new JToggleButton(perevodSIntegerVString(i,j));
                newButtons.setFont(new Font("Times New Roman", Font.BOLD, 30));
                buttonListenerEvent(newButtons,i,j);
                newButtons.setBounds(k,l,50,50);
                newButtons.setFocusable(false);
                panel.add(newButtons);
                if (k == 102){
                    k += 2;
                }
                if (k ==254 ){
                    k += 2;
                }
            }
            if (l == 102){
                l += 2;
            }
            if (l == 254){
                l +=2;
            }
        }
    }


    public void dotGameButtons(){//готова, как там пока
        MainWindow.jf.add(panel2);
        panel2.setBounds(2, 490, 462, 76);

        btnNewButton_1 = new JButton("1");
        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        destButton(btnNewButton_1,1);
        btnNewButton_1.setBounds(0, 11, 50, 50);
        btnNewButton_1.setBackground(Color.white);
        panel2.add(btnNewButton_1);

        btnNewButton_2 = new JButton("2");
        btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 30));
        destButton(btnNewButton_2,2);
        btnNewButton_2.setBounds(50, 11, 50, 50);
        btnNewButton_2.setBackground(Color.white);
        panel2.add(btnNewButton_2);

        btnNewButton_3 = new JButton("3");
        btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 30));
        destButton(btnNewButton_3,3);
        btnNewButton_3.setBounds(100, 11, 50, 50);
        btnNewButton_3.setBackground(Color.white);
        panel2.add(btnNewButton_3);

        btnNewButton_4 = new JButton("4");
        btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 30));
        destButton(btnNewButton_4,4);
        btnNewButton_4.setBounds(152, 11, 50, 50);
        btnNewButton_4.setBackground(Color.white);
        panel2.add(btnNewButton_4);

        btnNewButton_5 = new JButton("5");
        btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 30));
        destButton(btnNewButton_5,5);
        btnNewButton_5.setBounds(202, 11, 50, 50);
        btnNewButton_5.setBackground(Color.white);
        panel2.add(btnNewButton_5);

        btnNewButton_6 = new JButton("6");
        btnNewButton_6.setFont(new Font("Times New Roman", Font.BOLD, 30));
        destButton(btnNewButton_6,6);
        btnNewButton_6.setBounds(252, 11, 50, 50);
        btnNewButton_6.setBackground(Color.white);
        panel2.add(btnNewButton_6);

        btnNewButton_7 = new JButton("7");
        btnNewButton_7.setFont(new Font("Times New Roman", Font.BOLD, 30));
        destButton(btnNewButton_7,7);
        btnNewButton_7.setBounds(304, 11, 50, 50);
        btnNewButton_7.setBackground(Color.white);
        panel2.add(btnNewButton_7);

        btnNewButton_8 = new JButton("8");
        btnNewButton_8.setFont(new Font("Times New Roman", Font.BOLD, 30));
        destButton(btnNewButton_8,8);
        btnNewButton_8.setBounds(354, 11, 50, 50);
        btnNewButton_8.setBackground(Color.white);
        panel2.add(btnNewButton_8);

        btnNewButton_9 = new JButton("9");
        btnNewButton_9.setFont(new Font("Times New Roman", Font.BOLD, 30));
        destButton(btnNewButton_9,9);
        btnNewButton_9.setBounds(404, 11, 50, 50);
        btnNewButton_9.setBackground(Color.white);
        panel2.add(btnNewButton_9);

        panel2.setVisible(false);
    }

    public void destButton(JButton but, final int a){
        but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nubmer = a;
            }
        });
    }

    public void fasleButtons(){
        for (int i = 1; i < 10; i++) {
            int x = 0;
            for (int j = 0; j < Game.arrGame.length; j++) {
                for (int k = 0; k < Game.arrGame.length; k++) {
                    if (Game.arrGame[j][k] == i){
                        x++;
                    }
                }
            }
            if (x == 9){
                if(i == 1){
                    btnNewButton_1.setVisible(false);
                }
                if(i == 2){
                    btnNewButton_2.setVisible(false);
                }
                if(i == 3){
                    btnNewButton_3.setVisible(false);
                }
                if(i == 4){
                    btnNewButton_4.setVisible(false);
                }
                if(i == 5){
                    btnNewButton_5.setVisible(false);
                }
                if(i == 6){
                    btnNewButton_6.setVisible(false);
                }
                if(i == 7){
                    btnNewButton_7.setVisible(false);
                }
                if(i == 8){
                    btnNewButton_8.setVisible(false);
                }
                if(i == 9){
                    btnNewButton_9.setVisible(false);
                }
            }
            else {
                if(i == 1){
                    btnNewButton_1.setVisible(true);
                }
                if(i == 2){
                    btnNewButton_2.setVisible(true);
                }
                if(i == 3){
                    btnNewButton_3.setVisible(true);
                }
                if(i == 4){
                    btnNewButton_4.setVisible(true);
                }
                if(i == 5){
                    btnNewButton_5.setVisible(true);
                }
                if(i == 6){
                    btnNewButton_6.setVisible(true);
                }
                if(i == 7){
                    btnNewButton_7.setVisible(true);
                }
                if(i == 8){
                    btnNewButton_8.setVisible(true);
                }
                if(i == 9){
                    btnNewButton_9.setVisible(true);
                }
            }
        }
    }
}


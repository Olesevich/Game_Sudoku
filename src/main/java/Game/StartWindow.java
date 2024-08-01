package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;

public class StartWindow extends JPanel {


    private final JPanel panel;
    private JTextField textField;
    private JPanel panel_1;
    private JToggleButton tglbtnNewToggleButton, tglbtnNewToggleButton_1, tglbtnNewToggleButton_2;
    //private JToggleButton tglbtnNewToggleButton_1;
    //private JToggleButton tglbtnNewToggleButton_2;
    public static int level;
    private JButton btnNewButton_2;
    private JComboBox comboBox;
    private JButton btnNewButton_1;


    public StartWindow() {
        panel = new JPanel(null);
        panel.setBounds(0, 0, 458, 365);
        MainWindow.jf.add(panel);
        levelSelection();
        panel_1 = new JPanel(null);
        panel_1.setBounds(0, 363, 458, 190);
        MainWindow.jf.add(panel_1);
        vodNewPlayer();
        panel_1.setVisible(false);
        panel.setVisible(true);
        loadDataBasik();
    }


    public void levelSelection(){
        comboBox = new JComboBox();
        comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        comboBox.setBounds(34, 80, 202, 28);
        panel.add(comboBox);


        tglbtnNewToggleButton = new JToggleButton("Легкий");
        tglbtnNewToggleButton.setBounds(287, 71, 147, 48);
        tglbtnNewToggleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tglbtnNewToggleButton_1.setSelected(false);
                tglbtnNewToggleButton_2.setSelected(false);
                level = 50;
                startButton(tglbtnNewToggleButton);
            }
        });
        panel.add(tglbtnNewToggleButton);

        tglbtnNewToggleButton_1 = new JToggleButton("Средний");
        tglbtnNewToggleButton_1.setBounds(287, 129, 147, 48);
        tglbtnNewToggleButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tglbtnNewToggleButton.setSelected(false);
                tglbtnNewToggleButton_2.setSelected(false);
                level = 40;
                startButton(tglbtnNewToggleButton_1);
            }
        });
        panel.add(tglbtnNewToggleButton_1);

        tglbtnNewToggleButton_2 = new JToggleButton("Тяжелый");
        tglbtnNewToggleButton_2.setBounds(287, 188, 147, 48);
        tglbtnNewToggleButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tglbtnNewToggleButton_1.setSelected(false);
                tglbtnNewToggleButton.setSelected(false);
                level = 30;
                startButton(tglbtnNewToggleButton_2);
            }
        });
        panel.add(tglbtnNewToggleButton_2);

        JLabel lblNewLabel = new JLabel("Выбирите уровень сложности");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel.setBounds(270, 33, 191, 28);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Выбирите игрока");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(66, 33, 161, 28);
        panel.add(lblNewLabel_1);

        JButton btnNewButton = new JButton("Добавить");
        btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnNewButton.setBounds(10, 146, 120, 50);
        panel.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel_1.setVisible(true);
            }
        });

        btnNewButton_1 = new JButton("Удалить");
        btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnNewButton_1.setBounds(140, 146, 120, 50);
        panel.add(btnNewButton_1);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deletePlayerDataBasik();
                loadDataBasik();
                //comboBox.removeItem(comboBox.getSelectedItem());//потом удалить как доделаю основную часть, а это удаляет один выделеный элемент
            }
        });


        btnNewButton_2 = new JButton("Играть");
        btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnNewButton_2.setBounds(25, 285, 127, 64);
        panel.add(btnNewButton_2);
        btnNewButton_2.setEnabled(false);
        btnNewButton_2.setBackground(Color.green);
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                panel_1.setVisible(false);
                new DateBase();
                DateBase dateBase = new DateBase (1);//для тестов бд
                dateBase.gamesPlayed(comboBox.getSelectedItem());
                new Game(comboBox.getSelectedItem());
                MainWindow.jf.add(new GamePlay());
            }
        });

        JButton btnNewButton_2_1 = new JButton("Выход");
        btnNewButton_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnNewButton_2_1.setBounds(166, 285, 127, 64);
        panel.add(btnNewButton_2_1);
        btnNewButton_2_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

        JButton btnNewButton_2_2 = new JButton("Таблица");
        btnNewButton_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnNewButton_2_2.setBounds(307, 285, 127, 64);
        panel.add(btnNewButton_2_2);
        btnNewButton_2_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            new Tables(panel);
            }
        });
    }

    public void vodNewPlayer(){
        JLabel lblNewLabel_2 = new JLabel("Введите имя нового игрока");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNewLabel_2.setBounds(110, 26, 260, 37);
        panel_1.add(lblNewLabel_2);

        textField = new JTextField();
        textField.setFont(new Font(" ", Font.PLAIN, 18));
        textField.setBounds(145, 73, 127, 28);
        panel_1.add(textField);
        textField.setColumns(10);

        JButton btnNewButton_3 = new JButton("Добавить");//добавление игрока в БД
        btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btnNewButton_3.setBounds(135, 122, 148, 43);
        panel_1.add(btnNewButton_3);
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addPlayerDataBasik();
                loadDataBasik();
                panel_1.setVisible(false);
                textField.setText("");
            }
        });

    }

    public void startButton(JToggleButton but){
        if(but.isSelected()){
            btnNewButton_2.setEnabled(true);
        }
        else btnNewButton_2.setEnabled(false);
    }

    private void loadDataBasik(){
        comboBox.removeAllItems();
        DateBase dateBase = new DateBase(1);
        ArrayList<String> arrayList = dateBase.vivod_bd_na_ikran();
        for (int i = 0; i < arrayList.size(); i++) {
            comboBox.addItem(arrayList.get(i));
        }
    }

    private void deletePlayerDataBasik(){
        DateBase dateBase = new DateBase(1);
        dateBase.deletePlayerBD(comboBox.getSelectedItem().toString());
    }

    private void addPlayerDataBasik(){
        DateBase dateBase = new DateBase(1);
        dateBase.addPlayerBD(textField.getText());
    }

    public  Object namePlauerGames(){
        Object ob = (comboBox.getSelectedItem());
        return ob;
    }

}




package Game;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tables {

    private JScrollPane panelTables;

    private JTable table;

    private Object[][] array;

    private Object[] columnsHeader = new String[] {"Имя игрока", "Кол-во игр",
            "Побед"};
    private int hiegt_Button = 130;

    private JPanel jPanelButton;
    private JButton back;

    public Tables(JPanel panel) {
        panel.setVisible(false);
        loadDataBasik();
        table = new JTable(array,columnsHeader);
        panelTables =  new JScrollPane(table);
        panelTables.setBounds(0, 0, MainWindow.WIDTH, MainWindow.HIEGTH-hiegt_Button);
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)table.getDefaultRenderer(String.class);//выравнивает значение в ячейках
        renderer.setHorizontalAlignment(SwingConstants.CENTER);//выравнивает значение в ячейках
        MainWindow.jf.add(panelTables);
        creatPanel();
        creatBattun(panel);
    }

    private void loadDataBasik(){
        DateBase dateBase = new DateBase(1);
        array = new String [columnsHeader.length][dateBase.select_BD_Tables()];
        array = dateBase.retun_select_BD_Tables(columnsHeader.length, dateBase.select_BD_Tables());
    }

    private void creatPanel(){
        jPanelButton = new JPanel(Boolean.parseBoolean(BorderLayout.CENTER));
        jPanelButton.setBounds(0,MainWindow.HIEGTH-hiegt_Button,MainWindow.WIDTH-hiegt_Button-50,hiegt_Button-50);
        MainWindow.jf.add(jPanelButton);
    }

    private void creatBattun(final JPanel panel){
        back = new JButton("Назад");
        back.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        back.setBounds(0, 0, MainWindow.WIDTH, MainWindow.HIEGTH-hiegt_Button);
        //back.setBackground(Color.blue);
        jPanelButton.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelTables.setVisible(false);
                jPanelButton.setVisible(false);
                panel.setVisible(true);
            }
        });
    }

}

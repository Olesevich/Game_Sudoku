package Game;

import javax.swing.*;

public class Game {

    private static int [][] arr;
    public static int [][] arrGame;
    private static int p;
    private static boolean winnerWinner;
    private static Object perevodNameObek;
    private int a, b;



    public Game(Object object) {
        perevodNameObek = object;
        arrGame = new int[9][9];
        arr = CreatingGameArray.getArr();
        random_6();
//        test__vivodMassiva();
    }

    public void random_6(){
        for (int i = 0; i < StartWindow.level; i++) {
            random_6_numberGameStart();
        }
    }

    public int random_6_numberGameStart(){
        a = CreatingGameArray.randomNubmer();
        b = CreatingGameArray.randomNubmer();
        if (arrGame[a][b] == 0 ){
            arrGame[a][b] = arr[a][b];
            return a;
        }
        else return random_6_numberGameStart();
    }

    public static void test__vivodMassiva(){//для теста...
        for (int i = 0; i < arrGame.length; i++) {
            for (int j = 0; j < arrGame[i].length; j++) {
                System.out.print(arrGame[i][j] + " ");
                if(j == 1){
                    System.out.print(" ");
                }
            }
            System.out.println();
            if (i == 1){
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void superProverkaNaWinner (){
        int t = 0;
        for (int i = 0; i < arrGame.length; i++) {
            for (int j = 0; j < arrGame.length; j++) {
                if (arrGame[i][j] == arr[i][j]){
                    t++;
                }
            }
        }
        if(t == 81){
            winnerWinner = true;
            TimerLabel.stopTimer();
            JOptionPane.showMessageDialog(null,"Вы выиграли, Вам потребовалось " + TimerLabel.t/60
                    + "минут " + TimerLabel.t % 60 + " секунд");
            DateBase dateBase = new DateBase(1);
            dateBase.winPlayed(perevodNameObek);
            MainWindow.start();
        }
    }

    public static void proverkaNaFeil(){
        int t = 0;
        p = 0;
        for (int i = 0; i < arrGame.length; i++) {
            for (int j = 0; j < arrGame.length; j++) {
                if (arrGame[i][j] != 0){
                    t++;
                }
                if (arrGame[i][j] != arr[i][j] && arrGame[i][j] != 0){
                    p++;
                }
            }
        }
        if(t == 16 && !winnerWinner){
            JOptionPane.showMessageDialog(null, "Вами совершено " + p + " ошибок. Не растраивайтесь," +
                    " начните заново и у Вас все полчуется");
            GamePlay.panel.setVisible(false);
            MainWindow.jf.setVisible(false);
            MainWindow.start();
        }
    }

}

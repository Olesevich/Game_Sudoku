package Game;

public class CreatingGameArray {

    private static int [][] arr;
    private static int x;
    private static boolean winner;
    private static boolean superWin;
    private boolean prover;
    private  int [] array;


    public CreatingGameArray() {
        arr = new int[9][9];
        winner = false;
        superWin = false;
        prover = true;
//        randomNumber();// пробная версия была
//        sapolneniMassivTesta();//для теста
        fillingMassiva();
    }

    public void vivodMassiva(){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
                if (j == 2 || j == 5){
                    System.out.print("  ");
                }
            }
            System.out.println();
            if(i == 2 || i == 5){
                System.out.println();
            }
        }
    }

    public static int randomNubmer(){
        x = (int)(Math.random()*9);
        return x;
    }

    public void randomNumber(){
        for (int i = 0; i < arr.length; i++) {
            int a = randomNubmer();
            arr[a][i] = i+1;
        }
    }

    public void proverkaNaWinerSummer() {// проверка на вин, путем слажения всех значений строки или столбца идолжно равно быть 45
        int sum = 0;
        int a;
        int b;
        for (int i = 0; i < arr.length; i++) {
            a = 0; b = 0;
            for (int j = 0; j < arr.length; j++) {
                a += arr[i][j];
                b += arr[j][i];
            }
            if (a == 45){
                if(b == 45){
                    sum++;
                }
            }
        }
        if (sum == 9){
            winner = true;
            superWin = true;
            vivodMassiva();//пока в тести потом закаментила
            System.out.println("Победа!!!");
        }
    }

    public void proverkaNaOdinakChisla(){//проверка на одинаковые числа в строке или столбце
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (int k = j+1 ; k < arr.length; k++) {
                    if((arr[i][j] == arr[i][k]) && arr[i][j] != 0 ){
                        prover = false;
                        winner = true;
                        break;
                    }
                    if((arr[j][i] == arr [k][i]) && arr[j][i] != 0){
                        prover = false;
                        winner = true;
                        break;
                    }
                }
            }
        }
        for (int k = 0, p = 1, t = 2; k < 9; k+= 3, p+= 3, t += 3) {//проверкма нету ли одинаковых в квадрите
            for (int i = 0, e = 1, o = 2; i < 9; i += 3, e += 3, o += 3) {
                array = new int[9];
                array[0] = arr[k][i]; array[1] = arr[k][e]; array[2] = arr[k][o];
                array[3] = arr[p][i]; array[4] = arr[p][e]; array[5] = arr[p][o];
                array[6] = arr[t][i]; array[7] = arr[t][e]; array[8] = arr[t][o];
                for (int j = 0; j < array.length; j++) {
                    for (int l = j+1; l < array.length; l++) {
                        if (array[j] == array[l] && array[j] != 0){
                            prover = false;
                            winner = true;
                            break;
                        }
                    }
                }
            }
        }
    }

    public void fillingMassiva(){
        int x = randomNubmer();
        int y = randomNubmer();
        while(!superWin){
            int u = 1;
            if(arr[x][y] == 0){
                arr[x][y] = u;
                proverkaNaOdinakChisla();
                while (!prover){
                    u++;
                    if (u == 10){
                        arr[x][y] = 0;
                        if (y == 0){
                            x--;
                            y = 8;
                        }
                        else {
                            y--;
                        }
                        arr[x][y]++;
                        if (arr[x][y] == 10){
                            arr[x][y] = 0;
                            if (y == 0){
                                x--;
                                y = 8;
                            }
                            else {
                                y--;
                            }
                            arr[x][y]++;
                        }
                        u = arr[x][y];
                        prover = true;
                        proverkaNaOdinakChisla();
                    }
                    else {
                        arr[x][y] = u;
                        prover = true;
                        proverkaNaOdinakChisla();
                    }
                }
                y++;
                if(y == 9){
                    x++;
                    y = 0;
                }
                if (x == 9){
                    x = 0;
                    y = 0;
                }
            }
            proverkaNaWinerSummer();
        }
    }

    public void funkc(int r, int y){//пока не работает хз почему
        if (y == 0){
            r--;
            y = 8;
        }
        else {
            y--;
        }
    }

    public static int[][] getArr() {
        return arr;
    }

}

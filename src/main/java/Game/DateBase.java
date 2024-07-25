package Game;

import java.sql.*;
import java.util.ArrayList;

public class DateBase {

    String url = "jdbc:postgresql://localhost:5432/postgres",
            user = "postgres", password = "postgres",
            driv = "org.postgresql.Driver";
    Connection c = null;
    Statement statement;
    ResultSet resultSet;

    ArrayList<String> arrayBD = new ArrayList<String>();


    public DateBase() {
        try {
            podkluchenie_k_BD();
            //inseret_info_BD();//добавляет в бд значение
            //update_BD();//изменение колонки в бд
            //delete_BD();//удаление строки в бд
            select_BD();//читает все значение с бд
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public DateBase(int i){
        try {
            podkluchenie_k_BD();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void podkluchenie_k_BD()throws SQLException, ClassNotFoundException {
        Class.forName(driv);
        c = DriverManager.getConnection(url, user, password);
        statement = c.createStatement();

    }
    public void select_BD() {//для проверки и для тренировки, опрос что есть в базе
        try {
            String qure = "SELECT * FROM test";
            statement.setFetchSize(100);
            resultSet = statement.executeQuery(qure);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int price = resultSet.getInt(3);
                int win = resultSet.getInt(4);
                System.out.printf("%d. %s - %d - %d \n", id, name, price, win);

            }
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void inseret_info_BD() {//для тренировки
        try {
            int elem = statement.executeUpdate("INSERT INTO test(name, win) VALUES ('sasa', 0)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void update_BD(){//для тренировки
        try {
            int elem = statement.executeUpdate("UPDATE test SET Id = 5 WHERE name = 'sasa'");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void delete_BD(){//для тренировки
        try {
            int elem = statement.executeUpdate("DELETE FROM test WHERE Id > 1");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<String> vivod_bd_na_ikran(){//для программы
        try {
            String qure = "SELECT * FROM test";
            statement.setFetchSize(100);
            resultSet = statement.executeQuery(qure);
            while (resultSet.next()) {
                String name = resultSet.getString(2);
                arrayBD.add(name);
            }
            c.close();//

        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayBD;
    }

    public void addPlayerBD(String namePlayer){
        try {
            PreparedStatement ps = c.prepareStatement("INSERT INTO test(name, win, games) VALUES (?,?,?)");
            ps.setString(1, namePlayer);
            ps.setInt(2, 0);
            ps.setInt(3,0);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletePlayerBD(String namePlayer){
        try {
           // int elem = statement.executeUpdate("DELETE FROM test WHERE name = namePlayer");
            PreparedStatement ps = c.prepareStatement("DELETE FROM test WHERE name = ?");
            ps.setString(1, namePlayer);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void gamesPlayed (Object namePlayer){
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE test SET games = games+1 WHERE name = ?");
            ps.setObject(1,namePlayer);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void winPlayed (Object namePlayer){
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE test SET win = win+1 WHERE name = ?");
            ps.setObject(1,namePlayer);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int select_BD_Tables() {//для проверки и для тренировки, опрос что есть в базе
        int a = 0;
        try {
            statement.setFetchSize(100);
            resultSet = statement.executeQuery("SELECT * FROM test");
            while (resultSet.next()) {
                a++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    public Object[][] retun_select_BD_Tables(int a, int b) {//для проверки и для тренировки, опрос что есть в базе
        Object objekt [][] = new Object[a][b];
        try {
            statement.setFetchSize(100);
            resultSet = statement.executeQuery("SELECT * FROM test");
            int z = 0;
            while (resultSet.next()) {
                objekt[z][a-3] = resultSet.getString(2);
                objekt[z][a-2] = resultSet.getInt(4);
                objekt[z][a-1] = resultSet.getInt(3);
                z++;
            }
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objekt;
    }

}

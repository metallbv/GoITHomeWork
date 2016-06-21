package Research;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by v.babiak on 07.06.2016.
 */
public class DBConnector {

    private static final String URL = "jdbc:mysql://localhost:3306/onlineshopdb?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PUSSWORD = "root";

    public static void main(String[] args) {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USERNAME, PUSSWORD);
            System.out.println("Hura");
        } catch (SQLException e) {
            System.out.println("Не удалось получить соединение с БД! " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Не удалось получить соединение с БД! " + e.getMessage());
        }

    }
}

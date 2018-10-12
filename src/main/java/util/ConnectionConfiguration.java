package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by User on 10/12/2018.
 */
public class ConnectionConfiguration {
    public static final String URL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";

    public static final String USERNAME = "root";
    public static final String PASSWORD = "";

    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

}
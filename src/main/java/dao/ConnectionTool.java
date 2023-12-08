package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTool {
    private static Connection connexion = null;
    private static void connect() {

        try {

            Class.forName("com.mysql.jdbc.Driver");

            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3308/fpl2023", "root", "");

            System.out.println("Connexion 👌");


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnexion () {

        if(connexion == null)

            connect();

        return connexion;

    }
}

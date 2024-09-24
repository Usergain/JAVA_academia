package org.aartaraz.java.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    //Patron Singleton
    private static String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=Europe/Madrid";
    private static String username = "root";
    private static String password = "";
    private static Connection connection;

   //Conexion por consulta y operacion. Una conexion nueva, recurrencia
    public static Connection getInstance() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}

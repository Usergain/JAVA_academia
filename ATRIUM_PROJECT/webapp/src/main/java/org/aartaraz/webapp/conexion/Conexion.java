package org.aartaraz.webapp.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String NOMBRE_BD = "covidweb";
    private static final String URL_DB = "jdbc:mysql://localhost/" + NOMBRE_BD;
    private static final String USUARIO_DB = "root";
    private static final String PASS_DB = "";

    public Connection conectar() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, SQLException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection conConexion = DriverManager.getConnection(URL_DB, USUARIO_DB, PASS_DB);
        return conConexion;
    }
}

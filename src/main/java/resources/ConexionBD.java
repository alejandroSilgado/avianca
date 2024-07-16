package resources;

import java.sql.*;

public class ConexionBD {
    private static final String CONNECTION_URL = "jdbc:sqlserver://Avianca.mssql.somee.com;"
            + "databaseName=Avianca;"
            + "user=santiagosilgado_SQLLogin_1;"
            + "password=lb8d1zuu91;"
            + "encrypt=true;"
            + "trustServerCertificate=true;";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNECTION_URL);
    }
}
package com.ap;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.*;

public class ConnectionJDBC {
    //Atributtes
    static Dotenv dotenv = Dotenv.load();
    private static final String DB_USER = dotenv.get("DB_USER");
    private static final String DB_PASS = dotenv.get("DB_PASSWORD");
    private static final String DB_HOST = dotenv.get("DB_HOST");
    private static final String DB_PORT = dotenv.get("DB_PORT");
    private static final String DB_DATABASE = dotenv.get("DB_NAME");
    private static final String DB_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_DATABASE + "?useSSL=false&serverTimezone=UTC";


    // Methods
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        }
        catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
    public static void close(PreparedStatement stmt) {
        try {
            stmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
    public static void close(Connection conn) {
        try {
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
}

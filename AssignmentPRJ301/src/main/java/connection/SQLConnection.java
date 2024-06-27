/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class SQLConnection {
    public static final String HOSTNAME = "localhost\\MSSQLSERVER01";
    public static final String PORT = "1433";
    public static final String DBNAME = "PRJ301_SU23_DB";
    public static final String USERNAME = "sa";
    public static final String PASSWORD = "12345678";

    /**
     * Get connection to MSSQL Server
     * @return Connection
     * @throws java.lang.Exception
     */
    public static Connection getConnection() throws Exception {

        // Create a variable for the connection string.
        String connectionUrl = "jdbc:sqlserver://"+HOSTNAME+":"+PORT+";"
                + "databaseName="+DBNAME+";encrypt=true;trustServerCertificate=true;";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(connectionUrl, USERNAME, PASSWORD);
        }
        // Handle any errors that may have occurred.
        catch (ClassNotFoundException | SQLException e) {
            throw new Exception(e.getMessage());
        }
    }
}

package Wordle;

import java.sql.*;

/**
 * The DbFunctions class provides utility methods to manage database connections.
 * It facilitates connecting to a PostgreSQL database using JDBC by supplying
 * the database name, user credentials, and handling connection exceptions.
 */
public class DbFunctions {

    /**
     * Establishes a connection to a PostgreSQL database.
     *
     * @param dbname   The name of the database to connect to.
     * @param user     The username used for database access.
     * @param password The password associated with the specified user.
     * @return A Connection object to interact with the database, or null if the connection fails.
     */
    public Connection connectToDb(String dbname, String user, String password) {
        Connection con = null;
        try {
            // Load PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");
            // Attempt to establish a connection to the database
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, password);

            // Check if connection was successful
            if (con != null) {
                System.out.println("Connected to PostgreSQL database");
            } else {
                System.out.println("Failed to connect to PostgreSQL database");
            }
        } catch (Exception e) {
            // Output the exception message to the console
            System.out.println(e);
        }
        return con;
    }
}
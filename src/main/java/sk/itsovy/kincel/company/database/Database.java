package sk.itsovy.kincel.company.database;

import sk.itsovy.kincel.company.log.Log;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Database {
    String url = "jdbc:mysql://itsovy.sk:3306/world_x";
    String username="mysqluser";
    String password="Kosice2021!";


    Log log = new Log();
    public Connection getConnection() {
        try {
            Properties props = new Properties();
            InputStream loader = getClass().getClassLoader().getResourceAsStream("database.properties");
            props.load(loader);
            Connection con = DriverManager.getConnection(url, username, password);
            log.print("Connected");
            return con;
        } catch (SQLException | IOException ex) {
            log.error(ex.toString());
        }
        return(null);
    }

    public void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                log.error(e.toString());
            }
        }
    }
}
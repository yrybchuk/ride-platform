package pl.irybchuk.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class ConnectionUtil {

    private static final String CONNECTION_FILE_NAME = "src/main/resources/connection.properties";

    private ConnectionUtil() {} //private constructor


    public static Connection getConnection() {
        Properties connectionParameters = getConnectionParameters();
        String dbhost = connectionParameters.getProperty("db_host");
        String dbport = connectionParameters.getProperty("db_port");
        String dbname = connectionParameters.getProperty("db_name");
        String dbuser = connectionParameters.getProperty("db_user");
        String dbpassword = connectionParameters.getProperty("db_password");

        String dbURL = "jdbc:mysql://" + dbhost + ":" + dbport + "/" + dbname;

        Connection connection = null;
        try {
             connection = DriverManager.getConnection(dbURL, dbuser, dbpassword);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private static Properties getConnectionParameters(){

        Properties properties = null;

        try {
            FileReader fileInputStream = new FileReader(CONNECTION_FILE_NAME);
            properties = new Properties();
            properties.load(fileInputStream);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}

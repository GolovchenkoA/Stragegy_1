package ua.golovchenko.artem;

/**
 * Created by java on 20.02.2016.
 */

import com.mysql.jdbc.Driver;
//import org.postgresql.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class UtilityConnection {

    public static Connection createConnection() throws SQLException {

        Properties props = new Properties();
        Driver driver = new com.mysql.jdbc.Driver(); //mysql

        try(InputStream in = UtilityConnection.class.getClassLoader().getResourceAsStream("jdbc.properties");) {

            props.load(in);
            Class.forName(props.getProperty("jdbc.driver"));

            return DriverManager.getConnection(props.getProperty("jdbc.url"),
                    props.getProperty("jdbc.username"),
                    props.getProperty("jdbc.password"));

        } catch (IOException | ClassNotFoundException | SQLException e) {
            System.out.println("Cannot connect to database");
            e.printStackTrace();
        }
        return null;
    }

}

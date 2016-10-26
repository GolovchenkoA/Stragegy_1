package ua.golovchenko.artem;

/**
 * Created by java on 20.02.2016.
 */

import com.mysql.jdbc.Driver;
//import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilityConnection {

    public static Connection createConnection() throws SQLException {

        //Driver driver= new org.postgresql.Driver(); //postgresql
        Driver driver = new com.mysql.jdbc.Driver(); //mysql

        try {
            //PostgreSQL Connect
            //Class.forName("org.postgresql.Driver");
            //return DriverManager.getConnection("jdbc:postgresql://10.47.90.137:5432/Golovchenko_bank", "bank", "bank");

            //MySQL Connect
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/Strategy_1", "root", "Fzy84C");

        } catch (SQLException e) {
            System.out.println("Cannot connect to database");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}

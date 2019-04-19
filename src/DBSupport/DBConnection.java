/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBSupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Admin
 */
public class DBConnection {

    public static Connection establishDBConnection() throws SQLException,
            ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connect = null;
        Properties connectProp = new Properties();
        connectProp.put("dbms", "mysql");
        connectProp.put("user", "root");
        connectProp.put("password", "password");
        connectProp.put("useSSL", "false");

        connect = DriverManager.getConnection(
                "jdbc:" + "mysql" + "://" + "localhost" + ":" + 3306 + "/",
                connectProp);
        return connect;
    }
}

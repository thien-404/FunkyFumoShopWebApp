/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Shirakami Mishino
 */
public class DBUtils {
    private final static String DB_NAME="StoreManagement";
    private final static String USER_NAME="sa";
    private final static String PASSWORD="12345";
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection con = null;
        //1.load Driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //2.URl dia chi
        String url = "jdbc:sqlserver://localhost:1433;databaseName="+DB_NAME;
        //3.Get connection tu url
        con = DriverManager.getConnection(url, USER_NAME, PASSWORD);
        return con;
    }
}

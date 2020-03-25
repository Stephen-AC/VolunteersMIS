package edu.gdut.gytw.volunteerMIS.common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 222222
 * 33333
 */
public class DBconnection {
    public static Connection getConn() throws ClassNotFoundException, SQLException {
        Properties prop=new Properties();
        InputStream in = DBconnection.class.getClassLoader().getResourceAsStream("db.properties");//读取文件
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String user = prop.getProperty("username");
        String password = prop.getProperty("password");
        String url = prop.getProperty("url");
        String driver = prop.getProperty("driver");
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
}
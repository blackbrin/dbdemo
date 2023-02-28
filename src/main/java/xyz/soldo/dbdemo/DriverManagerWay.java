package xyz.soldo.dbdemo;

import java.sql.Connection;
import java.sql.DriverManager;

import static xyz.soldo.dbdemo.Common.url;

public class DriverManagerWay {
    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection(url, "root", "123456");
        Common.getData(connection);
    }
}

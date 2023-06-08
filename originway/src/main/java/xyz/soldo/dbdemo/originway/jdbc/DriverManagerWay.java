package xyz.soldo.dbdemo.originway.jdbc;

import xyz.soldo.dbdemo.originway.Utils;

import java.sql.*;

import static xyz.soldo.dbdemo.originway.Config.url;

/***
 * 通过DriverManager获取数据库连接
 */
public class DriverManagerWay {
    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection(url, "root", "123456");

        //Utils.getDataByStatement(connection);
        Utils.getDataByPrepareStatement(connection);
    }
}

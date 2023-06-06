package xyz.soldo.dbdemo.jdbc;


import xyz.soldo.dbdemo.Utils;

import java.sql.*;

import static xyz.soldo.dbdemo.Config.url;

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

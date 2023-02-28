package xyz.soldo.dbdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Common {
    public static String url = "jdbc:mysql://127.0.0.1:3306/dbdemo?useSSL=false&serverTimezone=UTC";


    public static void getData(Connection connection) throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user");
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println(1);
    }
}

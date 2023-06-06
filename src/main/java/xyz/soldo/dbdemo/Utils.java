package xyz.soldo.dbdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Utils {
    public static void getDataByStatement(Connection connection) {
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM user")) {
            while (rs.next()) {
                System.out.println(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getDataByPrepareStatement(Connection connection) throws Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM user WHERE id = ?");
            stmt.setInt(1, 1010);
            rs = stmt.executeQuery();
            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                sb.append(rs.getString("email"));
            }
            if (sb.length() > 0) {
                return sb.toString();
            } else {
                return "no data";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        } finally {
            stmt.close();
            rs.close();
        }
    }
}

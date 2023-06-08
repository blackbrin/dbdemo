package xyz.soldo.dbdemo.originway.hikari;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import xyz.soldo.dbdemo.originway.Config;
import xyz.soldo.dbdemo.originway.Utils;

import java.sql.Connection;

/**
 * 通过HikariCP连接池的方式连接数据库
 */
public class HikariCPWay {
    public static void main(String[] args) throws Exception {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(Config.url);
        config.setUsername("root");
        config.setPassword("123456");
        config.setConnectionTimeout(1000);
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(60000);

        HikariDataSource dataSource = new HikariDataSource(config);
        Connection connection = dataSource.getConnection();
        System.out.println(Utils.getDataByPrepareStatement(connection));
        connection.close();
    }
}

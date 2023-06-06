package xyz.soldo.dbdemo.druid;

import com.alibaba.druid.pool.DruidDataSource;
import xyz.soldo.dbdemo.Config;
import xyz.soldo.dbdemo.Utils;

import java.sql.Connection;

/***
 * 通过Druid连接池连接数据库
 */
public class DruidWay {
    public static void main(String[] args) throws Exception {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(Config.url);
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setInitialSize(5);
        dataSource.setMinIdle(5);
        dataSource.setMaxActive(10);
        dataSource.setMaxWait(1000);
        dataSource.setPoolPreparedStatements(true);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(10);
        Connection connection = dataSource.getConnection();
        System.out.println(Utils.getDataByPrepareStatement(connection));
        connection.close();
    }
}

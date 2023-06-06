package xyz.soldo.dbdemo.jdbc;


import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.cj.jdbc.MysqlXADataSource;
import xyz.soldo.dbdemo.Utils;

import javax.sql.ConnectionPoolDataSource;
import javax.sql.DataSource;
import javax.sql.XADataSource;
import java.sql.Connection;

import static xyz.soldo.dbdemo.Config.url;

/***
 * 通过DataSource获取数据库连接
 */
public class DataSourceWay {
    public static void main(String[] args) throws Exception {
        doPoolDatasource();
        //doXADatasource();
    }

    /***
     * 通过 MysqlConnectionPoolDataSource 获取数据库连接
     * 适用于常规的数据库操作场景，如单机应用程序和Web应用程序等。
     * 该数据源管理自己的连接池，避免了频繁建立和关闭连接的开销，提高了系统的性能和可靠性。
     * 可以预先创建和缓存一定数量的连接，以减少连接请求时的延迟，提高系统的响应速度。
     */
    public static void doPoolDatasource() throws Exception {
        MysqlConnectionPoolDataSource poolDataSource = new MysqlConnectionPoolDataSource();
        poolDataSource.setURL(url);
        poolDataSource.setUser("root");
        poolDataSource.setPassword("123456");
        poolDataSource.setConnectTimeout(10);
        Connection connection = poolDataSource.getConnection();
        Utils.getDataByPrepareStatement(connection);
        connection.close();
    }

    /***
     * 通过 MysqlXADataSource 获取数据库连接
     * 适用于两阶段提交（2PC）事务，如分布式事务处理。
     * XADataSource 通过 XA 协议与事务管理器进行通信，并且支持局部回滚和全局回滚。
     * 支持XA协议，可以处理分布式事务，具有很好的可扩展性和可靠性。
     * 但是，由于2PC事务需要协调多个资源管理器之间的状态，因此会产生比较高的性能开销。
     */
    public static void doXADatasource() throws Exception {
        MysqlXADataSource xaDataSource = new MysqlXADataSource();
        xaDataSource.setURL(url);
        Connection connection = xaDataSource.getConnection("root", "123456");
        Utils.getDataByPrepareStatement(connection);
        connection.close();
    }
}

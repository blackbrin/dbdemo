package xyz.soldo.dbdemo;


import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.cj.jdbc.MysqlXADataSource;

import javax.sql.ConnectionPoolDataSource;
import javax.sql.DataSource;
import javax.sql.XADataSource;
import java.sql.Connection;

import static xyz.soldo.dbdemo.Common.url;

public class DataSourceWay {
    public static void main(String[] args) throws Exception {
        //doPoolDatasource();
        doXADatasource();
    }

    public static void doPoolDatasource() throws Exception {
        MysqlConnectionPoolDataSource poolDataSource = new MysqlConnectionPoolDataSource();
        poolDataSource.setURL(url);
        Connection connection = poolDataSource.getConnection("root", "123456");
        Common.getData(connection);
    }

    public static void doXADatasource() throws Exception {
        MysqlXADataSource xaDataSource = new MysqlXADataSource();
        xaDataSource.setURL(url);
        Connection connection = xaDataSource.getConnection("root", "123456");
        Common.getData(connection);
    }
}

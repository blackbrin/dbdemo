package xyz.soldo.dbdemo.originway.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

public class PoolDruidDataSource extends PooledDataSourceFactory {
    public PoolDruidDataSource() {
        this.dataSource = new DruidDataSource();
    }
}

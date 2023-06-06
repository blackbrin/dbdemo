package xyz.soldo.dbdemo.druid;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.soldo.dbdemo.Utils;

import java.sql.Connection;

/**
 * 通过spring druid的方式连接数据库
 */
@RestController
public class DruidSpringWay {
    @Qualifier("mydruidDataSource")
    @Autowired
    DruidDataSource druidDataSource;

    @PostMapping("/druidSpringWay")
    public String druidSpringWay() throws Exception {
        Connection connection = druidDataSource.getConnection();
        return Utils.getDataByPrepareStatement(connection);
    }
}

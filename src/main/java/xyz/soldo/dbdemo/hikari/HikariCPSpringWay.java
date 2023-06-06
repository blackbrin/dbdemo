package xyz.soldo.dbdemo.hikari;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.soldo.dbdemo.Utils;

import javax.sql.DataSource;
import java.sql.Connection;

@RestController
public class HikariCPSpringWay {
    @Qualifier("myHikariDatasource")
    @Autowired
    HikariDataSource dataSource;

    @PostMapping("/hikariCPSpringWay")
    public String hikariCPSpringWay() throws Exception {
        Connection connection = dataSource.getConnection();
        return Utils.getDataByPrepareStatement(connection);
    }
}

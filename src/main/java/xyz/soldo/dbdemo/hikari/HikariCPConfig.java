package xyz.soldo.dbdemo.hikari;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

@Configuration
public class HikariCPConfig {
    @Bean(name = "myHikariDatasource")
    public HikariDataSource myHikariDatasource(@Qualifier("hikariConfig") HikariConfig config) {
        return new HikariDataSource(config);
    }

    @Bean(name = "hikariConfig")
    @Scope("prototype")
    @ConfigurationProperties(prefix = "myhikari.datasource")
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }

}

package xyz.soldo.dbdemo.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.wall.WallFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class DruidConfig {
    @Value("${mydruid.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${mydruid.datasource.url}")
    private String url;

    @Value("${mydruid.datasource.username}")
    private String username;

    @Value("${mydruid.datasource.password}")
    private String password;

    @Value("${mydruid.datasource.druid.initial-size}")
    private int initialSize;

    @Value("${mydruid.datasource.druid.min-idle}")
    private int minIdle;

    @Value("${mydruid.datasource.druid.max-active}")
    private int maxActive;

    @Value("${mydruid.datasource.druid.max-wait}")
    private long maxWait;

    @Value("${mydruid.datasource.druid.time-between-eviction-runs-millis}")
    private long timeBetweenEvictionRunsMillis;

    @Value("${mydruid.datasource.druid.filters}")
    private String filters;

    @Bean(name = "mydruidDataSource")
    public DruidDataSource mydruidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxWait(maxWait);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);

        try {
            dataSource.setFilters(filters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    //监控
    /**
     * 注册ServletRegistrationBean
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        // 创建servlet注册实体
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        // 设置IP白名单
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
        // 设置IP黑名单，优先级高于白名单
        servletRegistrationBean.addInitParameter("deny", "");
        // 设置控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        servletRegistrationBean.addInitParameter("loginPassword", "123456");
        // 是否可以重置数据
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }
}

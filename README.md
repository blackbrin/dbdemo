# dbdemo

## 项目介绍
该项目是一个简单的数据库操作的demo，
主要是为了学习数据库操作的一些基本知识，包括数据库的连接以及数据库的连接池的使用等等。

## 项目结构

### 创建测试表
    
```sql
create database dbdemo;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
`phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '手机号码',
`email` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '邮箱',
`password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '密码',
`nick_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '昵称',
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (`id`) USING BTREE,
UNIQUE INDEX `uniqe_key_email`(`email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1010 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;
```

### 通过原生JDBC操作数据库

1. DataSource
2. DriverManager

### 通过HikariCP连接池操作数据库
1.原生操作 HikariCPWay
```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.0.31</version>
</dependency>
```

2.Spring集成 HikariCPSpringWay

使用Java注解的方式配置bean
```java
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
```

### 通过Druid连接池操作数据库

1.原生操作 DruidWay
```xml

<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.2.6</version>
</dependency>
```

2.Spring集成 DruidSpringWay

3.Druid 监控

### 通过JPA操作数据库

1.原生操作 JPAWay

2.Spring集成 JPASpringWay

### 通过Mybatis操作数据库



## 注意

由于需要在单个项目使用多种连接池，故采用代码注册bean的方式，在单连接池项目可以依赖spring 自动注入的方式。



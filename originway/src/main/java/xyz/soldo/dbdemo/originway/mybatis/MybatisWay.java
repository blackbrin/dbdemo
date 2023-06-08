package xyz.soldo.dbdemo.originway.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import xyz.soldo.dbdemo.originway.model.User;
import xyz.soldo.dbdemo.originway.mybatis.mapper.UserMapper;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

public class MybatisWay {

    public static void main(String[] args) throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<User> users = userMapper.getAllUsers();
            System.out.println(users.stream().map(User::getEmail).collect(Collectors.joining(",")));
        }
    }
}

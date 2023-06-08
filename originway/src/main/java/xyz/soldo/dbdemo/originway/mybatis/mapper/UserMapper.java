package xyz.soldo.dbdemo.originway.mybatis.mapper;

import org.apache.ibatis.annotations.Insert;
import xyz.soldo.dbdemo.originway.model.User;

import java.util.List;

public interface UserMapper {
    List<User> getAllUsers();

    @Insert("INSERT INTO user (nick_name, email) VALUES (#{nick_name}, #{email})")
    void addUser(User user);
}

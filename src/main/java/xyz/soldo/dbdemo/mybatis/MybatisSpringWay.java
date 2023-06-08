package xyz.soldo.dbdemo.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.soldo.dbdemo.originway.model.User;
import xyz.soldo.dbdemo.originway.mybatis.mapper.UserMapper;

@RestController
@RequestMapping("/mybatis")
public class MybatisSpringWay {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user) {
        userMapper.addUser(user);
    }
}

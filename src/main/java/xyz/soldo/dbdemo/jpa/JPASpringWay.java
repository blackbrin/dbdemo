package xyz.soldo.dbdemo.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.soldo.dbdemo.originway.model.User;

import java.util.List;

/**
 * 通过Spring Data JPA的方式操作数据库
 */
@RestController
@RequestMapping("/JPA")
public class JPASpringWay {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/getUserById/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping("/saveOrUpdateUser")
    public void saveOrUpdateUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @PostMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
    }
}

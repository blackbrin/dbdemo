package xyz.soldo.dbdemo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.soldo.dbdemo.originway.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

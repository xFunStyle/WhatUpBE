package io.spring.core.user;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository {
    void save(User user);

    Optional<User> findById(String id);

    Optional<User> findByName(String name);

    Optional<User> findByEmail(String email);

    List<User> findAll();
}

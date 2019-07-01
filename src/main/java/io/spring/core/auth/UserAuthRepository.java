package io.spring.core.auth;

import io.spring.core.user.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAuthRepository {
    List<Auth> findById(String userId);

    Auth save(User user);

    void deleteEntries(String userId);
}

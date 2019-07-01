package io.spring.core.message;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository {
    void save(Message message);

    Optional<Message> findById(String id);

    List<Message> findByReceiverId(String receiverId);

    Optional<Message> findBySenderId(String senderId);

    List<Message> findAll();
}

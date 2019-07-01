package io.spring.infrastructure.repository;

import io.spring.core.message.Message;
import io.spring.core.message.MessageRepository;
import io.spring.core.user.User;
import io.spring.infrastructure.mybatis.mapper.MessageQueueMapper;
import io.spring.infrastructure.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MyBatisMessageRepository implements MessageRepository {
    private final MessageQueueMapper messageQueueMapper;

    @Autowired
    public MyBatisMessageRepository(MessageQueueMapper messageQueueMapper) {
        this.messageQueueMapper = messageQueueMapper;
    }

    @Override
    public void save(Message message) {
            messageQueueMapper.insert(message);
    }

    @Override
    public Optional<Message> findBySenderId(String senderId) {
        return Optional.ofNullable(messageQueueMapper.findBySenderId(senderId));
    }

    @Override
    public List<Message> findByReceiverId(String receiverId) {
        System.out.println(receiverId);
        return messageQueueMapper.findByReceiverId(receiverId);
    }

    @Override
    public Optional<Message> findById(String id) {
        return Optional.ofNullable(messageQueueMapper.findById(id));
    }

    @Override
    public List<Message> findAll(){
        return messageQueueMapper.findAll();
    }
}
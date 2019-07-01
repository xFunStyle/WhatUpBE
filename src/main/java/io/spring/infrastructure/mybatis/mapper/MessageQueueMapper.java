package io.spring.infrastructure.mybatis.mapper;

import io.spring.core.message.Message;
import io.spring.core.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MessageQueueMapper {
    void insert(@Param("message") Message message);

    Message findBySenderId(@Param("senderId") String senderId);

    List<Message> findByReceiverId(@Param("receiverId") String receiverId);

    Message findById(@Param("id") String id);

    List<Message> findAll();
}

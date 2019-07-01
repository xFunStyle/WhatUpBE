package io.spring.infrastructure.repository;

import io.spring.core.message.Message;
import io.spring.core.message.MessageBlock;
import io.spring.core.message.MessageBlockRepository;
import io.spring.infrastructure.mybatis.mapper.MessageBlockMapper;
import io.spring.infrastructure.mybatis.mapper.MessageQueueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisMessageBlockRepository implements MessageBlockRepository {

    private MessageBlockMapper messageBlockMapper;

    @Autowired
    public MyBatisMessageBlockRepository(MessageBlockMapper messageBlockMapper) {
        this.messageBlockMapper = messageBlockMapper;
    }

    @Override
    public void deleteBlock(String blockId){
        messageBlockMapper.deleteBlock(blockId);
    }

    @Override
    public void saveBlock(MessageBlock messageBlock){
        for(Message m:messageBlock.getMessages()){
            messageBlockMapper.saveBlock(messageBlock.getBlockId(),  m.getId());
        }
    }
}

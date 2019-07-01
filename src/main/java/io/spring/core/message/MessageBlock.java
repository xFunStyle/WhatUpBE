package io.spring.core.message;

import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.UUID;

public class MessageBlock {
    private String blockId;
    private List<Message> messages;

    public MessageBlock(List<Message> messages){
        this.blockId = UUID.randomUUID().toString();
        this.messages = messages;
    }

    public String getBlockId() {
        return blockId;
    }

    public List<Message> getMessages() {
        return messages;
    }
}

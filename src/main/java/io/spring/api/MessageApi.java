package io.spring.api;

import io.spring.core.auth.UserAuthRepository;
import io.spring.core.message.Message;
import io.spring.core.message.MessageBlock;
import io.spring.core.message.MessageBlockRepository;
import io.spring.core.message.MessageRepository;
import io.spring.util.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/messages")
public class MessageApi {
    private MessageRepository messageRepository;
    private UserAuthRepository userAuthRepository;
    private MessageBlockRepository messageBlockRepository;

    public MessageApi(MessageRepository messageRepository, UserAuthRepository userAuthRepository, MessageBlockRepository messageBlockRepository) {
        this.messageRepository = messageRepository;
        this.userAuthRepository = userAuthRepository;
        this.messageBlockRepository = messageBlockRepository;
    }

    @RequestMapping(path = "/send")
    public ResponseEntity sendMessage(@RequestParam String senderId, @RequestParam String receiverId, @RequestParam String text, @RequestParam String authKey){
        if(userAuthRepository.findById(senderId).isEmpty()||!userAuthRepository.findById(senderId).get(0).getAuthKey().equals(authKey)){
            System.out.println("Permission denied");
            return ResponseEntity.status(401).body(ResponseUtil.createMessageUnauthorizedResponse());
        }
        Message message = new Message(senderId, receiverId, text);
        messageRepository.save(message);
        return ResponseEntity.status(201).body(ResponseUtil.createMessageSendResponse(message));
    }

    @RequestMapping(path = "/fetch")
    public ResponseEntity getMessageQueue(@RequestParam String id, @RequestParam String authKey){
        if(userAuthRepository.findById(id).isEmpty()||!userAuthRepository.findById(id).get(0).getAuthKey().equals(authKey)){
            System.out.println("Permission denied");
            return ResponseEntity.status(401).body(ResponseUtil.createMessageUnauthorizedResponse());
        }
        List<Message> messages = messageRepository.findByReceiverId(id);
        MessageBlock block = new MessageBlock(messages);
        messageBlockRepository.saveBlock(block);
        return ResponseEntity.status(200).body(ResponseUtil.createMessageFetchResponse(messages, block.getBlockId()));
    }

    @RequestMapping(path = "confirmReceived")
    public ResponseEntity confirmReceivedMessages(@RequestParam String blockId){
        return ResponseEntity.status(200).body("");
    }
}

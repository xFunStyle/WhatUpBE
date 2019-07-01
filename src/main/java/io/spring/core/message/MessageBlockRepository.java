package io.spring.core.message;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageBlockRepository {
    void deleteBlock(String blockId);

    void saveBlock(MessageBlock messageBlock);
}

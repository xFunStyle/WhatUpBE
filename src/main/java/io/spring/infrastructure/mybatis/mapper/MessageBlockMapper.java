package io.spring.infrastructure.mybatis.mapper;

import io.spring.core.message.MessageBlock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MessageBlockMapper {
    void deleteBlock(@Param("blockId") String blockId);

    void saveBlock(@Param("blockId") String blockId, @Param("messageId") String messageId);
}

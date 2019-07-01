package io.spring.infrastructure.mybatis.mapper;

import io.spring.core.auth.Auth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserAuthMapper {
    List<Auth> findById(@Param("userId") String userId);

    void insert(@Param("auth") Auth auth);

    void deleteEntries(@Param("userId") String userId);
}

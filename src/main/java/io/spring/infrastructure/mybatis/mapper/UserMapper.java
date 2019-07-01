package io.spring.infrastructure.mybatis.mapper;

import io.spring.core.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    void insert(@Param("user") User user);

    User findByName(@Param("name") String name);

    User findByEmail(@Param("email") String email);

    User findById(@Param("id") String id);

    void update(@Param("user") User user);

    List<User> findAll();
}
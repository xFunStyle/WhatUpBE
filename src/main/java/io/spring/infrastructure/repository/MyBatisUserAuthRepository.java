package io.spring.infrastructure.repository;

import io.spring.core.auth.Auth;
import io.spring.core.auth.UserAuthRepository;
import io.spring.core.user.User;
import io.spring.infrastructure.mybatis.mapper.UserAuthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class MyBatisUserAuthRepository implements UserAuthRepository{
    private final UserAuthMapper userAuthMapper;

    @Autowired
    public MyBatisUserAuthRepository(UserAuthMapper userAuthMapper) {
        this.userAuthMapper = userAuthMapper;
    }

    @Override
    public List<Auth> findById(String userId){ return userAuthMapper.findById(userId);}

    @Override
    public Auth save(User user){
        userAuthMapper.insert(new Auth(user.getId(), UUID.randomUUID().toString()));
        return userAuthMapper.findById(user.getId()).get(0);
    }

    @Override
    public void deleteEntries(String userId){
        userAuthMapper.deleteEntries(userAuthMapper.findById(userId).get(0).getUserId());
    }
}

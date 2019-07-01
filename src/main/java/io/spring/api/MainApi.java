package io.spring.api;

import io.spring.core.user.User;
import io.spring.core.user.UserRepository;
import io.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MainApi {

    private UserRepository userRepository;

    @Autowired
    public MainApi(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @RequestMapping(path = "/")
    public ResponseEntity home(){
        return ResponseEntity.status(201).body(ResponseUtil.createIndexResponse());
    }
}

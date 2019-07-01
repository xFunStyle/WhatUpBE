package io.spring.api;

import io.spring.core.user.UserRepository;
import io.spring.util.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetUsersApi {

    private UserRepository userRepository;

    public GetUsersApi(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @RequestMapping(path = "/getUsers")
    public ResponseEntity getUsers(){
        return ResponseEntity.status(200).body(ResponseUtil.createGetUsersResponse(userRepository.findAll()));
    }

}

package io.spring.api;

import io.spring.core.auth.UserAuthRepository;
import io.spring.core.user.User;
import io.spring.core.user.UserRepository;
import io.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginApi {

    private UserRepository userRepository;
    private UserAuthRepository userAuthRepository;

    @Autowired
    public LoginApi(UserRepository userRepository, UserAuthRepository userAuthRepository){
        this.userRepository = userRepository;
        this.userAuthRepository = userAuthRepository;
    }

    @RequestMapping(path = "/login")
    public ResponseEntity login(@RequestParam(value = "name") String name,
                      @RequestParam(value = "password") String password){
        Map<String, String> map= checkInput(name, password);
        if(!map.isEmpty()){
            return ResponseEntity.status(409).body(map);
        }
        if(!userAuthRepository.findById(userRepository.findByName(name).get().getId()).isEmpty()){
            System.out.println("1");
            userAuthRepository.deleteEntries(userRepository.findByName(name).get().getId());
        }
        return ResponseEntity.status(200).body(ResponseUtil.createUserAuthResponse(userRepository.findByName(name).get(), userAuthRepository.save(userRepository.findByName(name).get())));
    }

    @RequestMapping(path = "/register")
    public ResponseEntity register(@RequestParam(value = "name") String name,
                                   @RequestParam(value = "email") String email,
                                   @RequestParam(value = "password") String password){
        User temp = new User(name, email, password);
        Map<String, String> map = checkDuplicateUser(temp);
        if(!map.isEmpty()){
            return ResponseEntity.status(409).body(map);
        }
        userRepository.save(temp);
        return ResponseEntity.status(201).body(ResponseUtil.createUserResponse(temp));
    }


    public Map<String, String> checkDuplicateUser(User user){
        return new HashMap<String, String>(){{
            int code=100;
            if(userRepository.findByEmail(user.getEmail()).isPresent()){
                put("" + code, "email"); code++;
            }
            if(userRepository.findByName(user.getName()).isPresent()){
                put("" + code, "name"); code++;
            }
            if(userRepository.findById(user.getId()).isPresent()){
                put("" + code, "id"); code++;
            }
        }};
    }

    public Map<String, String> checkInput(String name, String password){
        return new HashMap<String, String>(){{
            int code=1;
            if(userRepository.findByName(name).isPresent()&&userRepository.findByName(name).get().getPassword().equals(password)){
                //TODO: Cleanup
            }else{
                put("" + 100, "name or password");
            }
        }};
    }
}
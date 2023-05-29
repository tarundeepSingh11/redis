package controller;

import com.RedisWithSpring.redisCode.modal.User;
import com.RedisWithSpring.redisCode.sevice.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisServiceImpl redisService;

    @PostMapping("/user")
    public ResponseEntity<String> saveUser(@RequestBody User user){
        System.out.println(user.getId());
        boolean result=redisService.saveUser(user);
        if(result)
            return ResponseEntity.ok("User Created Successfully!!");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/all/user")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users;
        users =redisService.getALlUser();
        return ResponseEntity.ok(users);
    }


}


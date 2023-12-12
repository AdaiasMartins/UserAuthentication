package com.example.UserAuthentication.User.Services;

import com.example.UserAuthentication.User.DTO.RegisterDTO;
import com.example.UserAuthentication.User.Entities.User;
import com.example.UserAuthentication.User.Repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    public ResponseEntity<User> register(RegisterDTO data, UserRepository repository){
        User user = new User(data);
        repository.save(user);

        return ResponseEntity.ok(user);
    }

}

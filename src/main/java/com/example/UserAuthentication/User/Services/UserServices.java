package com.example.UserAuthentication.User.Services;

import com.example.UserAuthentication.User.DTO.RegisterDTO;
import com.example.UserAuthentication.User.Entities.UserCustomer;
import com.example.UserAuthentication.User.Repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    public ResponseEntity<UserCustomer> register(RegisterDTO data, UserRepository repository){
        UserCustomer user = new UserCustomer(data);
        repository.save(user);

        return ResponseEntity.ok(user);
    }

}

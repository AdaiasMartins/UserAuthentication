package com.example.UserAuthentication.User.Services;

import com.example.UserAuthentication.User.DTO.LoginDTO;
import com.example.UserAuthentication.User.DTO.RegisterDTO;
import com.example.UserAuthentication.User.Entities.UserCustomer;
import com.example.UserAuthentication.User.Exceptions.UserNotFoundFoundException;
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

    public ResponseEntity<UserCustomer> login(LoginDTO data, UserRepository repository){
        UserCustomer user = repository.findByEmail(data.email());
        if(user.getPassword().equals(data.password())){
            return ResponseEntity.ok(user);
        }
        throw new UserNotFoundFoundException("O usuário não foi encontrado");
    }

}

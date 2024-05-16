package com.example.UserAuthentication.User.Controllers;

import com.example.UserAuthentication.User.DTO.LoginDTO;
import com.example.UserAuthentication.User.DTO.RegisterDTO;
import com.example.UserAuthentication.User.DTO.UpdateDTO;
import com.example.UserAuthentication.User.Entities.UserCustomer;
import com.example.UserAuthentication.User.Exceptions.UserAlreadyExistsException;
import com.example.UserAuthentication.User.Exceptions.UserNotFoundFoundException;
import com.example.UserAuthentication.User.Repository.UserRepository;
import com.example.UserAuthentication.User.Services.UserServices;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserServices services;

    @PostMapping("/singup")
    @Transactional
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data, UriComponentsBuilder uriBuilder) throws UserAlreadyExistsException {
        try {
            UserCustomer user = services.register(data);
            var uri = uriBuilder.path("/user/singup/{id}").buildAndExpand(user.getId()).toUri();
            return ResponseEntity.created(uri).body(user);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PostMapping("/SingIn")
    @Transactional
    public ResponseEntity login(@RequestBody @Valid LoginDTO data) throws UserNotFoundFoundException {
        try {
            return ResponseEntity.ok(services.login(data));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity getUsers() throws UserNotFoundFoundException {
        try {
            return ResponseEntity.ok(services.getUsers());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity userUpdate(@RequestBody @Valid UpdateDTO data) throws UserNotFoundFoundException {
        try {
            return ResponseEntity.ok(services.updateUser(data));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            services.delete(id);
            return ResponseEntity.ok().body("Código enviado com sucesso");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }


}

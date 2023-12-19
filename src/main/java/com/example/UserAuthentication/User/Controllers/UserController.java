package com.example.UserAuthentication.User.Controllers;

import com.example.UserAuthentication.User.DTO.LoginDTO;
import com.example.UserAuthentication.User.DTO.RegisterDTO;
import com.example.UserAuthentication.User.DTO.UpdateDTO;
import com.example.UserAuthentication.User.Entities.UserCustomer;
import com.example.UserAuthentication.User.Exceptions.UserNotFoundFoundException;
import com.example.UserAuthentication.User.Repository.UserRepository;
import com.example.UserAuthentication.User.Services.UserServices;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserServices services;

    @PostMapping("/SingUp")
    @Transactional
    public ResponseEntity<UserCustomer> register(@RequestBody @Valid RegisterDTO data){
        return services.register(data);
    }
    @PostMapping("/SingIn")
    @Transactional
    public ResponseEntity<UserCustomer> login(@RequestBody @Valid LoginDTO data) throws UserNotFoundFoundException {
        return services.login(data);
    }

    @GetMapping
    public ResponseEntity<List<UserCustomer>> getUsers(){
        return services.getUsers();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<UserCustomer> userUpdate(@RequestBody @Valid UpdateDTO data){
        return services.updateUser(data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        return services.delete(id);
    }


}

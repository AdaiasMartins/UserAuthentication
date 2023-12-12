package com.example.UserAuthentication.User.Controllers;

import com.example.UserAuthentication.User.DTO.RegisterDTO;
import com.example.UserAuthentication.User.Repository.UserRepository;
import com.example.UserAuthentication.User.Services.UserServices;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserServices services;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        return services.register(data, repository);
    }

}

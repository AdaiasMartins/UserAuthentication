package com.example.UserAuthentication.User.Services;

import com.example.UserAuthentication.User.DTO.LoginDTO;
import com.example.UserAuthentication.User.DTO.RegisterDTO;
import com.example.UserAuthentication.User.DTO.UpdateDTO;
import com.example.UserAuthentication.User.Entities.UserCustomer;
import com.example.UserAuthentication.User.Exceptions.UserAlreadyExistsException;
import com.example.UserAuthentication.User.Exceptions.UserNotFoundFoundException;
import com.example.UserAuthentication.User.Repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    UserRepository repository;

    public UserCustomer register(@RequestBody @Valid RegisterDTO data) throws UserAlreadyExistsException {
        if(repository.findByEmail(data.email()) != null){
            throw new UserAlreadyExistsException("O usuario informado ja esta cadastrado");
        }
        UserCustomer user = new UserCustomer(data);
        return repository.save(user);
    }

    public UserCustomer login(@RequestBody @Valid LoginDTO data) throws UserNotFoundFoundException {
        UserCustomer user = repository.findByEmail(data.email());
        if(user.getPassword().equals(data.password())){
            return user;
        }
        throw new UserNotFoundFoundException("O usuário não foi encontrado");
    }

    public List<UserCustomer> getUsers() throws UserNotFoundFoundException {
        var users = repository.findAll();
        if(users.isEmpty()){
            throw new UserNotFoundFoundException("Ainda não há nenhum usuário cadastrado");
        }
        return users;
    }

    public UserCustomer updateUser(UpdateDTO data) throws UserNotFoundFoundException {
        if(repository.getReferenceById(data.id()) != null){
            UserCustomer user = repository.getReferenceById(data.id());
            user.updateInfo(data);
            return user;
        }
        throw new UserNotFoundFoundException("O usuário não foi encontrado");
    }

    public void delete(Long id){
        repository.deleteById(id);
    }



}

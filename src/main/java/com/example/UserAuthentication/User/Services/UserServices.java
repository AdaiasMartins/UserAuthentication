package com.example.UserAuthentication.User.Services;

import com.example.UserAuthentication.User.DTO.LoginDTO;
import com.example.UserAuthentication.User.DTO.RegisterDTO;
import com.example.UserAuthentication.User.DTO.UpdateDTO;
import com.example.UserAuthentication.User.Entities.UserCustomer;
import com.example.UserAuthentication.User.Exceptions.UserNotFoundFoundException;
import com.example.UserAuthentication.User.Repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    public ResponseEntity<UserCustomer> register(RegisterDTO data, UserRepository repository){
        UserCustomer user = new UserCustomer(data);
        repository.save(user);

        return ResponseEntity.ok(user);
    }

    public ResponseEntity<UserCustomer> login(LoginDTO data, UserRepository repository) throws UserNotFoundFoundException {
        UserCustomer user = repository.findByEmail(data.email());
        if(user.getPassword().equals(data.password())){
            return ResponseEntity.ok(user);
        }
        throw new UserNotFoundFoundException("O usuário não foi encontrado");
    }

    public ResponseEntity<List<UserCustomer>> getUsers(UserRepository repository){
        var list = repository.findAll();

        return ResponseEntity.ok(list);
    }

    public ResponseEntity<UserCustomer> updateUser(UpdateDTO data, UserRepository repository){
        UserCustomer user = repository.getReferenceById(data.id());
        user.updateInfo(data);

        return ResponseEntity.ok(user);

    }

    public ResponseEntity<Void> delete(Long id, UserRepository repository){
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }



}

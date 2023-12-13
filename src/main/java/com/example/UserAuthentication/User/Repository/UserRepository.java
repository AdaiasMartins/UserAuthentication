package com.example.UserAuthentication.User.Repository;

import com.example.UserAuthentication.User.Entities.UserCustomer;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserCustomer, Long> {

    UserCustomer findByEmail(String email);
}

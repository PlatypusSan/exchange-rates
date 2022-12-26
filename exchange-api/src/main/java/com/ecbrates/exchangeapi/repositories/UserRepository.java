package com.ecbrates.exchangeapi.repositories;

import com.ecbrates.exchangeapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByLogin(String login);
}
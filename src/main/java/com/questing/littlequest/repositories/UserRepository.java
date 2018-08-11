package com.questing.littlequest.repositories;

//application Model import
import com.questing.littlequest.models.Users;

//JPA Spring library import and Spring repository inmport
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Java library imports for user data manipulation and management
import javax.transaction.Transactional;
import java.util.List;

//repository interface that extends JPA Repository
//unlike other repositories in the application
//to make full functionality of login, logout and delete user
//this repository has several methods called on User objects and a related String
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    List<Users> findByUsername(String username);
    Users findUsersByUsername(String username);

    @Transactional
    String deleteByUsername(String username);

    @Transactional
    List<Users> removeByUsername(String username);}
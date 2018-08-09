package com.questing.littlequest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.questing.littlequest.models.Users;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    List<Users> findByUsername(String username);
    Users findUsersByUsername(String username);

    @Transactional
    String deleteByUsername(String username);

    @Transactional
    List<Users> removeByUsername(String username);}
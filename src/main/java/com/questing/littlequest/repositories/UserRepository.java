package com.questing.littlequest.repositories;

import javafx.beans.binding.MapBinding;
import javafx.collections.ObservableMap;
import org.springframework.data.jpa.repository.JpaRepository;
import com.questing.littlequest.models.Users;

import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    List<Users> findByUsername(String username);
    Users findUsersByUsername(String username);
}
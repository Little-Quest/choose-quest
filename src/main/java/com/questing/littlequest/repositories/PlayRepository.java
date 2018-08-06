package com.questing.littlequest.repositories;

import com.questing.littlequest.models.Play;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayRepository extends JpaRepository<Play, Long> {
}

package com.questing.littlequest.repositories;

import com.questing.littlequest.models.Choices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChoicesRepository extends JpaRepository<Choices, Long> {
}

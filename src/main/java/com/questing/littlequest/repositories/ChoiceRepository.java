package com.questing.littlequest.repositories;

import com.questing.littlequest.models.Choices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChoiceRepository extends JpaRepository<Choices, Long> {
}

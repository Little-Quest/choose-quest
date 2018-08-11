package com.questing.littlequest.repositories;

//application Model import
import com.questing.littlequest.models.Choices;

//JPA Spring library import
import org.springframework.data.jpa.repository.JpaRepository;

//repository interface that extends JPA Repository
public interface ChoiceRepository extends JpaRepository<Choices, Long> {
}

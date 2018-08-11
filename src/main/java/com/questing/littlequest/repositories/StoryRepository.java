package com.questing.littlequest.repositories;

//application Model import
import com.questing.littlequest.models.Stories;

//JPA Spring library import
import org.springframework.data.jpa.repository.JpaRepository;

//repository interface that extends JPA Repository
public interface StoryRepository extends JpaRepository<Stories, Long> {
}

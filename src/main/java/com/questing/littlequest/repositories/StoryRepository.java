package com.questing.littlequest.repositories;

import com.questing.littlequest.models.Stories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Stories, Long> {
}

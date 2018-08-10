package com.questing.littlequest.repositories;

import com.questing.littlequest.models.Prompts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromptRepository extends JpaRepository<Prompts, Long> {

}

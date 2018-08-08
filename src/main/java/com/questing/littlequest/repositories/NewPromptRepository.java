package com.questing.littlequest.repositories;

import com.questing.littlequest.models.NewPromptTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewPromptRepository extends JpaRepository<NewPromptTable, Long> {
}

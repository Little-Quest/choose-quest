package com.questing.littlequest.repositories;

import com.questing.littlequest.models.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {
}

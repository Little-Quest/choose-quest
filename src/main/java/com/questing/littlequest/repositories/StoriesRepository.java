package com.questing.littlequest.repositories;

import com.questing.littlequest.models.Stories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoriesRepository extends JpaRepository<Stories, Long> {
}

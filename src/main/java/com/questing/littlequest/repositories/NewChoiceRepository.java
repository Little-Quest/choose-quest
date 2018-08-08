package com.questing.littlequest.repositories;

import com.questing.littlequest.models.NewChoiceTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewChoiceRepository extends JpaRepository<NewChoiceTable, Long> {
}

package com.Gangadhar.expenseapp.repository;

import com.Gangadhar.expenseapp.entity.Settlement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettlementRepository extends JpaRepository<Settlement, Long> {
}

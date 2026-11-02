package com.zanzibar.backend.repository;

import com.zanzibar.backend.model.Investor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestorRepository extends JpaRepository<Investor, Long> {
}

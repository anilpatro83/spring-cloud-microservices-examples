package com.portfolio.tracker.dto.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.tracker.dto.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
	List<Quote> findByUserId(Long userId);
}

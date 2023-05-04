package com.asi1.GameCard.trading.repository;

import com.asi1.GameCard.trading.model.Trading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradingRepository extends JpaRepository<Trading, Long> {
}

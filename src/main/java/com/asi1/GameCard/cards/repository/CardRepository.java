package com.asi1.GameCard.cards.repository;

import com.asi1.GameCard.cards.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {

}

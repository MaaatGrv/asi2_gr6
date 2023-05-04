package com.asi1.GameCard.cards.service;

import com.asi1.GameCard.cards.model.Card;
import com.asi1.GameCard.cards.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Card getCard(Long id) {
        return cardRepository.findById(id).orElse(null);
    }

    public Card updateCard(Long id, Card updatedCard) {
        if (cardRepository.existsById(id)) {
            updatedCard.setId(id);
            return cardRepository.save(updatedCard);
        }
        return null;
    }

    public void deleteCard(Long id) {
        cardRepository.deleteById(id);
    }

    public Card createCard(Card newCard) {
        return cardRepository.save(newCard);
    }

    public List<Card> getCardsToSell() {
        // TODO: Implement this method
        return null;
    }

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Optional<Card> findCardById(Long cardId) {
        return cardRepository.findById(cardId);
    }
}

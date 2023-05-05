package com.asi1.GameCard.cards.controller;

import com.asi1.GameCard.cards.model.Card;
import com.asi1.GameCard.cards.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card-rest-controller")
public class CardController {

	private final CardService cardService;

	@Autowired
	public CardController(CardService cardService) {
		this.cardService = cardService;
	}

	@GetMapping("/cards")
	public ResponseEntity<List<Card>> getAllCards() {
		List<Card> cards = cardService.getAllCards();
		return ResponseEntity.ok(cards);
	}

	@GetMapping("/card/{id}")
	public ResponseEntity<Card> getCard(@PathVariable Long id) {
		Card card = cardService.getCard(id);
		return ResponseEntity.ok(card);
	}

	@PostMapping("/card")
	public ResponseEntity<Card> createCard(@RequestBody Card card) {
		Card savedCard = cardService.createCard(card);
		return ResponseEntity.ok(savedCard);
	}

	@PutMapping("/card/{id}")
	public ResponseEntity<Card> updateCard(@PathVariable Long id, @RequestBody Card card) {
		Card updatedCard = cardService.updateCard(id, card);
		return ResponseEntity.ok(updatedCard);
	}

	@DeleteMapping("/card/{id}")
	public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
		cardService.deleteCard(id);
		return ResponseEntity.ok().build();
	}

	// Ajoutez les méthodes pour les autres opérations spécifiques (cards_to_sell,
	// etc.)
}
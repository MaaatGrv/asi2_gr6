package com.asi1.GameCard.cards.controller;

import com.asi1.GameCard.cards.model.Card;
import com.asi1.GameCard.cards.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {

	private static String messageLocal = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.";

	private final CardService cardService;

	@Autowired
	public CardController(CardService cardService) {
		this.cardService = cardService;
	}

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("messageLocal", messageLocal);
		return "index";
	}

	@GetMapping("/create-card")
	public String showCreateCardForm(Model model) {
		model.addAttribute("cardForm", new Card());
		return "create-card";
	}

	@PostMapping("/create-card")
	public String createCard(@ModelAttribute("cardForm") Card card, Model model) {
		// Sauvegardez la carte en utilisant le service CardService
		Card savedCard = cardService.createCard(card);

		// Affichez les données de la carte sauvegardée
		model.addAttribute("card", savedCard);
		return "display-card";
	}

	// Ajoutez les méthodes pour les autres opérations CRUD (Get, Update, Delete,
	// etc.)

	@GetMapping("/cards")
	public String getAllCards(Model model) {
		List<Card> cards = cardService.getAllCards();
		model.addAttribute("cards", cards);
		return "cards";
	}

	@GetMapping("/card/{id}")
	public String getCard(@PathVariable Long id, Model model) {
		Card card = cardService.getCard(id);
		model.addAttribute("card", card);
		return "display-card";
	}

	@GetMapping("/card/{id}/edit")
	public String showUpdateCardForm(@PathVariable Long id, Model model) {
		Card card = cardService.getCard(id);
		model.addAttribute("cardForm", card);
		return "update-card";
	}

	@PostMapping("/card/{id}/edit")
	public String updateCard(@PathVariable Long id, @ModelAttribute("cardForm") Card card, Model model) {
		Card updatedCard = cardService.updateCard(id, card);
		model.addAttribute("card", updatedCard);
		return "display-card";
	}

	@GetMapping("/card/{id}/delete")
	public String deleteCard(@PathVariable Long id, Model model) {
		cardService.deleteCard(id);
		return "redirect:/cards";
	}
}
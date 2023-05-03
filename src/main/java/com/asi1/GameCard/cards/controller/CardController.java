package com.asi1.GameCard.cards.controller;

import com.asi1.GameCard.cards.model.Card;
import com.asi1.GameCard.cards.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
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
}

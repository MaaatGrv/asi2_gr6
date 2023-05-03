package com.asi1.GameCard.rest;

import com.asi1.GameCard.model.Card;
import com.asi1.GameCard.model.CardFormDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestCrt {

	private static String messageLocal = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.";

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("messageLocal", messageLocal);
		return "index";
	}

	@GetMapping("/create-card")
	public String showCreateCardForm(Model model) {
		model.addAttribute("cardForm", new CardFormDTO());
		return "create-card";
	}

	@PostMapping("/create-card")
	public String createCard(@ModelAttribute("cardForm") CardFormDTO cardForm, Model model) {
		// Créez un nouvel objet Card à partir des données du DTO
		Card card = new Card();
		card.setName(cardForm.getName());
		card.setDescription(cardForm.getDescription());
		card.setFamily(cardForm.getFamily());
		card.setAffinity(cardForm.getAffinity());
		card.setImgUrl(cardForm.getImgUrl());
		card.setSmallImgUrl(cardForm.getSmallImgUrl());
		card.setEnergy(cardForm.getEnergy());
		card.setHp(cardForm.getHp());
		card.setDefense(cardForm.getDefense());
		card.setAttack(cardForm.getAttack());
		card.setPrice(cardForm.getPrice());

		// Simulez la sauvegarde de la carte et l'affichage des données
		model.addAttribute("card", card);
		return "display-card";
	}
}
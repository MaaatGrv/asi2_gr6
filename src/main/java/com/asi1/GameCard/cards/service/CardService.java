package com.asi1.GameCard.cards.service;

import com.asi1.GameCard.cards.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CardService {
    private final String apiUrl = "http://vps.cpe-sn.fr:8083";
    private final RestTemplate restTemplate;

    @Autowired
    public CardService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Card getCard(Long id) {
        String url = apiUrl + "/card/" + id;
        ResponseEntity<Card> response = restTemplate.getForEntity(url, Card.class);
        return response.getBody();
    }

    public Card updateCard(Long id, Card updatedCard) {
        String url = apiUrl + "/card/" + id;
        HttpEntity<Card> request = new HttpEntity<>(updatedCard);
        ResponseEntity<Card> response = restTemplate.exchange(url, HttpMethod.PUT, request, Card.class);
        return response.getBody();
    }

    public void deleteCard(Long id) {
        String url = apiUrl + "/card/" + id;
        restTemplate.delete(url);
    }

    public Card createCard(Card newCard) {
        String url = apiUrl + "/card";
        ResponseEntity<Card> response = restTemplate.postForEntity(url, newCard, Card.class);
        return response.getBody();
    }

    public List<Card> getCardsToSell() {
        String url = apiUrl + "/cards_to_sell";
        ResponseEntity<Card[]> response = restTemplate.getForEntity(url, Card[].class);
        return Arrays.asList(response.getBody());
    }

    public List<Card> getAllCards() {
        String url = apiUrl + "/cards";
        ResponseEntity<Card[]> response = restTemplate.getForEntity(url, Card[].class);
        return Arrays.asList(response.getBody());
    }
}

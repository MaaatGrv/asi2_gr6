package com.asi1.GameCard.cards.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Card {
    private String name;
    private String description;
    private String family;
    private String affinity;
    private String imgUrl = "https://via.placeholder.com/300x400?text=No+image+available";
    private String smallImgUrl = "https://via.placeholder.com/100x150?text=No+image+available";
    private double energy;
    private double hp;
    private double defense;
    private double attack;
    private double price;
    @Id
    private Long id;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setAffinity(String affinity) {
        this.affinity = affinity;
    }

    public String getAffinity() {
        return affinity;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        if (imgUrl == null || imgUrl.isEmpty()) {
            this.imgUrl = "https://via.placeholder.com/300x400?text=No+image+available";
        } else {
            this.imgUrl = imgUrl;
        }
    }

    public String getSmallImgUrl() {
        return smallImgUrl;
    }

    public void setSmallImgUrl(String smallImgUrl) {
        if (smallImgUrl == null || smallImgUrl.isEmpty()) {
            this.smallImgUrl = "https://via.placeholder.com/100x150?text=No+image+available";
        } else {
            this.smallImgUrl = smallImgUrl;
        }
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        if (energy < 0) {
            this.energy = 0;
        } else {
            this.energy = energy;
        }
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        if (hp < 0) {
            this.hp = 0;
        } else {
            this.hp = hp;
        }
    }

    public void setDefense(double defense) {
        if (defense < 0) {
            this.defense = 0;
        } else {
            this.defense = defense;
        }
    }

    public double getDefense() {
        return defense;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        if (attack < 0) {
            this.attack = 0;
        } else {
            this.attack = attack;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            this.price = 0;
        } else {
            this.price = price;
        }
    }

    // Constructors

    public Card() {
        this.name = "";
        this.description = "";
        this.family = "";
        this.affinity = "";
        this.imgUrl = "https://via.placeholder.com/300x400?text=No+image+available";
        this.smallImgUrl = "https://via.placeholder.com/100x150?text=No+image+available";
        this.energy = 0;
        this.hp = 0;
        this.defense = 0;
        this.attack = 0;
        this.price = 0;
    }

    public Card(String name, String description, String family, String affinity, String imgUrl, String smallImgUrl,
            double energy, double hp, double defense, double attack, double price) {
        this.name = name;
        this.description = description;
        this.family = family;
        this.affinity = affinity;
        this.imgUrl = imgUrl;
        this.smallImgUrl = smallImgUrl;
        this.energy = energy;
        this.hp = hp;
        this.defense = defense;
        this.attack = attack;
        this.price = price;
    }

    // Methods
}

package com.asi1.GameCard.cards.model;

public class CardFormDTO {
    private String name;
    private String description;
    private String family;
    private String affinity;
    private String imgUrl;
    private String smallImgUrl;
    private double energy;
    private double hp;
    private double defense;
    private double attack;
    private double price;

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
        this.imgUrl = imgUrl;
    }

    public String getSmallImgUrl() {
        return smallImgUrl;
    }

    public void setSmallImgUrl(String smallImgUrl) {
        this.smallImgUrl = smallImgUrl;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

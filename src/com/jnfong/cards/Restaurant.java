package com.jnfong.cards;

public abstract class Restaurant implements Card {
    public int getInitAmount() {
        return 6;
    }
    public int coinsToSteal() { return 1; }
    public CardIcon getIcon() { return CardIcon.CUP; }
}

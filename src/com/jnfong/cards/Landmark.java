package com.jnfong.cards;

public abstract class Landmark implements Card {

    public int getInitAmount() {
        return 4;
    }
    public CardIcon getIcon() { return CardIcon.MAJOR; }

}

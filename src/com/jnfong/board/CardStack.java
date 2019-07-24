package com.jnfong.board;

import com.jnfong.cards.Card;

import java.util.ArrayList;

public class CardStack {
    private Card cardType;
    private int amountRemaining;

    public CardStack(int cardId) {
        System.out.println("Initializing CardStack with ID: " + cardId);
        cardType = CardFactory.generate(cardId);
        int initAmount = cardType.getInitAmount();
        amountRemaining = initAmount;

        System.out.println("Initialized stack of " + amountRemaining + " " + cardType.toString() + "'s\n");
    }
}

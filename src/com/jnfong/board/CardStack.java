package com.jnfong.board;

import com.jnfong.cards.Card;

import java.util.ArrayList;

public class CardStack {
    private Card cardType;
    private int amountRemaining;

    public CardStack(int cardId) {
        cardType = CardFactory.generate(cardId);
        int initAmount = cardType.getInitAmount();
        amountRemaining = initAmount;

    }

    public String toString() {
        return cardType + " Qty: " + amountRemaining + " Price: " + cardType.getPrice();
    }

    public Card getCardType() {
        return cardType;
    }

    public Card getCard() {
        amountRemaining--;
        return CardFactory.generate(cardType.getId());
    }
}

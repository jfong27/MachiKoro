package com.jnfong.cards;

public interface Card {
   int getPrice();
   int getId();
   int getInitAmount();
   boolean isActivated(int rollNum);
}

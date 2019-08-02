package com.jnfong.cards;

public interface Card {
   int getPrice();
   int getId();
   int getInitAmount();
   CardIcon getIcon();
   boolean isActivated(int rollNum);
}

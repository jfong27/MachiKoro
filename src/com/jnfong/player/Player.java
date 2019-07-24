package com.jnfong;

import com.jnfong.cards.Bakery;
import com.jnfong.cards.Card;
import com.jnfong.cards.WheatField;

import java.util.ArrayList;
import java.util.List;

public class Player {

   private int id;
   private int coins;
   private List<Card> cards;
   private boolean hasTrainStation;

   public Player(int id) {
      this.id = id;
      hasTrainStation = false;
      coins = 3;
      cards = new ArrayList<>();
      cards.add(new WheatField());
      cards.add(new Bakery());
   }

   public String toString() {
      return "Player " + id;
   }

   public boolean hasTrainStation() {
      return hasTrainStation;
   }

}

package com.jnfong.player;

import com.jnfong.board.Game;
import com.jnfong.cards.Bakery;
import com.jnfong.cards.Card;
import com.jnfong.cards.WheatField;

import java.util.ArrayList;
import java.util.List;

public class Player {

   private int id;
   private int coins;
   private List<Card> cards;
   private boolean[] landmarks;

   public Player(int id) {
      this.id = id;
      landmarks = new boolean[Game.NUM_LANDMARKS];
      coins = 3;
      cards = new ArrayList<>();
      cards.add(new WheatField());
      cards.add(new Bakery());
   }

   public String toString() {
      return "Player " + id;
   }

   public boolean hasTrainStation() {
      return landmarks[0];
   }

   public boolean hasShoppingMall() {
      return landmarks[1];
   }

   public boolean hasAmusementPark() {
      return landmarks[2];
   }

   public boolean hasRadioTower() {
      return landmarks[3];
   }

}

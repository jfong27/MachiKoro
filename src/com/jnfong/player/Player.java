package com.jnfong.player;

import com.jnfong.board.Game;
import com.jnfong.cards.*;

import java.util.ArrayList;
import java.util.List;

public class Player {

   private int id;
   private int coins;
   private List<Restaurant> redCards;
   private List<PrimaryIndustry> blueCards;
   private List<Card> purpleGreenCards;
   private boolean[] landmarks;

   public Player(int id) {
      this.id = id;
      coins = 3;
      redCards = new ArrayList<>();
      blueCards = new ArrayList<>();
      purpleGreenCards = new ArrayList<>();
      landmarks = new boolean[Game.NUM_LANDMARKS];

      blueCards.add(new WheatField());
      purpleGreenCards.add(new Bakery());

   }

   public void takeCoins(int amount) {
      coins -= amount;
      if (coins < 0) {
         coins = 0;
      }
   }

   public void giveCoins(int amount) { coins += amount; }

   public int getNumCoins() { return coins; }

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

   public int activateRed(int roll) {

      int coinsToSteal = 0;

      for (Restaurant restaurant : redCards) {
         if (restaurant.isActivated(roll)) {
            coinsToSteal += restaurant.coinsToSteal();
         }
      }

      return coinsToSteal;

   }

   public void activateBlue(int roll) {
      for (PrimaryIndustry card : blueCards) {
         if (card.isActivated(roll)) {
            coins += card.getPayout();
         }
      }
   }

   public void activatePurpleGreen(int roll) {
      for (Card card : purpleGreenCards) {
         if (card.isActivated(roll)) {
            // TODO: ACTIVATE PG CARDS
         }
      }
   }

}

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
   private List<SecondaryIndustry> greenCards;
   private List<MajorEstablishment> purpleCards;
   private boolean[] landmarks;

   public Player(int id) {
      this.id = id;
      coins = 3;
      redCards = new ArrayList<>();
      blueCards = new ArrayList<>();
      greenCards = new ArrayList<>();
      purpleCards = new ArrayList<>();
      landmarks = new boolean[Game.NUM_LANDMARKS];

      blueCards.add(new WheatField());
      greenCards.add(new Bakery());

   }

   public void takeCoins(int amount) {
      coins -= amount;
      if (coins < 0) {
         coins = 0;
      }
   }

   public void giveCoins(int amount) { coins += amount; }

   public void giveCard(Card card) {
      if (Restaurant.class.isAssignableFrom(card.getClass())) {
         redCards.add((Restaurant)card);
      } else if (PrimaryIndustry.class.isAssignableFrom(card.getClass())) {
         blueCards.add((PrimaryIndustry)card);
      } else if (SecondaryIndustry.class.isAssignableFrom(card.getClass())) {
         greenCards.add((SecondaryIndustry)card);
      } else {
         purpleCards.add((MajorEstablishment)card);
      }
   }

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
            System.out.println(String.format("%s gets %d coins because of %s",
                                             this.toString(), card.getPayout(), card.toString()));
            coins += card.getPayout();
         }
      }
   }

   public void activateGreen(int roll) {
      for (SecondaryIndustry card : greenCards) {
         if (card.isActivated(roll)) {
            coins += card.getPayout(blueCards);
         }
      }
   }

   //TODO: Implement
   public void activatePurple(int roll) {
      for (MajorEstablishment card : purpleCards) {
         if (card.isActivated(roll)) {
            System.out.println(card.toString() + "IS ACTIVATED");
         }
      }
   }

}

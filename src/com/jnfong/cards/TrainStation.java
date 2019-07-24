package com.jnfong.cards;

public class TrainStation extends Landmark {

   private int price = 4;

   public int getPrice() { return price; }

   @Override
   public boolean isActivated(int rollNumber, int playerId) {
      return false;
   }

   @Override
   public int getId() {
      return 15;
   }
}


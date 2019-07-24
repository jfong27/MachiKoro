package com.jnfong.cards;

public class TrainStation extends Landmark {

   private static final int PRICE = 4;
   private static final int ID = 15;
   private static final CardIcon ICON = CardIcon.MAJOR;

   @Override
   public int getPrice() {
      return PRICE;
   }

   @Override
   public int getId() {
      return ID;
   }

   @Override
   public boolean isActivated(int rollNumber, int playerId) {
      return true;
   }


}


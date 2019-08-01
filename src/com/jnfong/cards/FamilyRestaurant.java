package com.jnfong.cards;

public class FamilyRestaurant extends Restaurant {

    private static final int PRICE = 3;
    private static final int ID = 11;
    private static final int ACTIVATION_NUM = 1;
    private static final int COINS_TO_STEAL = 2;
    private static final CardIcon ICON = CardIcon.CUP;

    @Override
    public int getPrice() {
        return PRICE;
    }

    @Override
    public int getId() {
        return ID;
    }

    @Override
    public boolean isActivated(int rollNumber) {
        return rollNumber == ACTIVATION_NUM;
    }

    @Override
    public int coinsToSteal() { return COINS_TO_STEAL; }

    public String toString() {
        return "Wheat Field";
    }
}

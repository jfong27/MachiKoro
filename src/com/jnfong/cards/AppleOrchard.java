package com.jnfong.cards;

public class AppleOrchard extends PrimaryIndustry {

    private static final int PRICE = 3;
    private static final int ID = 4;
    private static final CardIcon ICON = CardIcon.WHEAT;

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
        return rollNumber == 10;
    }

    public String toString() {
        return "Apple Orchard";
    }
}

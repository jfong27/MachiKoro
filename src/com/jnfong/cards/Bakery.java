package com.jnfong.cards;

public class Bakery extends SecondaryIndustry {

    private static final int PRICE = 1;
    private static final int ID = 5;
    private static final CardIcon ICON = CardIcon.BREAD;

    @Override
    public int getPrice() {
        return PRICE;
    }

    @Override
    public int getId() { return ID; }

    public boolean isActivated(int rollNumber, int playerId) {
        return rollNumber == 1;
    }

    public String toString() {
        return "Bakery";
    }
}

package com.jnfong.cards;

public class Mine extends PrimaryIndustry {

    private static final int PRICE = 6;
    private static final int ID = 3;
    private static final CardIcon ICON = CardIcon.GEAR;

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
        return rollNumber == 9;
    }

    public String toString() {
        return "Mine";
    }
}

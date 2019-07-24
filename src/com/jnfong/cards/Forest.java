package com.jnfong.cards;

public class Forest extends PrimaryIndustry {

    private static final int PRICE = 3;
    private static final int ID = 2;
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
        return rollNumber == 5;
    }

    public String toString() {
        return "Forest";
    }
}

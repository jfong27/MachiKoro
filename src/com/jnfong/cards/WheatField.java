package com.jnfong.cards;

public class WheatField extends PrimaryIndustry {

    private static final int PRICE = 1;
    private static final int ID = 0;
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
        return rollNumber == 1;
    }

    public String toString() {
        return "Wheat Field";
    }
}

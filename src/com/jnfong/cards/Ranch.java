package com.jnfong.cards;

public class Ranch extends PrimaryIndustry {

    private static final int PRICE = 1;
    private static final int ID = 1;
    private static final CardIcon ICON = CardIcon.COW;

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
        return rollNumber == 2;
    }

    public String toString() { return "Ranch"; }
}

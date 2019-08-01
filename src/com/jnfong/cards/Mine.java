package com.jnfong.cards;

public class Mine extends PrimaryIndustry {

    private static final int PRICE = 6;
    private static final int ID = 3;
    private static final int ACTIVATION_NUM = 9;
    private static final int PAYOUT = 5;
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
    public boolean isActivated(int rollNumber) {
        return rollNumber == ACTIVATION_NUM;
    }

    @Override
    public int getPayout() { return PAYOUT; }

    public String toString() {
        return "Mine";
    }
}

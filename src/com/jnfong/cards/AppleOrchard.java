package com.jnfong.cards;

public class AppleOrchard extends PrimaryIndustry {

    private static final int PRICE = 3;
    private static final int ID = 4;
    private static final int ACTIVATION_NUM = 10;
    private static final int PAYOUT = 3;
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
    public boolean isActivated(int rollNum) { return rollNum == ACTIVATION_NUM; }

    @Override
    public int getPayout() { return PAYOUT; }

    @Override
    public CardIcon getIcon() { return ICON; }

    public String toString() {
        return "Apple Orchard";
    }
}

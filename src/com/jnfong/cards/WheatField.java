package com.jnfong.cards;

public class WheatField extends PrimaryIndustry {

    private static final int PRICE = 1;
    private static final int ID = 0;
    private static final int ACTIVATION_NUM = 1;
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
    public boolean isActivated(int rollNum) {
        return rollNum == ACTIVATION_NUM;
    }

    public String toString() {
        return "Wheat Field";
    }
}

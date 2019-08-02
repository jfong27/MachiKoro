package com.jnfong.cards;

public class BusinessCenter extends MajorEstablishment {
    private static final int PRICE = 8;
    private static final int ID = 14;
    private static final int ACTIVATION_NUM = 6;
    private static final CardIcon ICON = CardIcon.MAJOR;

    @Override
    public int getPrice() { return PRICE; }

    @Override
    public int getId() { return ID; }

    @Override
    public CardIcon getIcon() { return ICON; }

    @Override
    public boolean isActivated(int rollNum) {
        return rollNum == ACTIVATION_NUM;
    }

    public String toString() { return "Business Center"; }
}

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

    @Override
    public CardIcon getIcon() { return ICON; }

    public boolean isActivated(int rollNumber) {
        return rollNumber == 1 || rollNumber == 2;
    }

    public String toString() {
        return "Bakery";
    }
}

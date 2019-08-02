package com.jnfong.cards;

import java.util.List;

public class ConvenienceStore extends SecondaryIndustry {

    private static final int PRICE = 2;
    private static final int ID = 6;
    private static final int ACTIVATION_NUM = 4;
    private static final int PAYOUT = 3;
    private static final CardIcon ICON = CardIcon.BREAD;

    @Override
    public int getPrice() {
        return PRICE;
    }

    @Override
    public int getId() { return ID; }

    @Override
    public CardIcon getIcon() { return ICON; }

    @Override
    public int getPayout(List<PrimaryIndustry> blues) { return PAYOUT; }

    public boolean isActivated(int rollNumber) {
        return rollNumber == ACTIVATION_NUM;
    }

    public String toString() {
        return "Convenience Store";
    }
}

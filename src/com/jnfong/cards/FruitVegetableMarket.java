package com.jnfong.cards;

import java.util.List;

public class FruitVegetableMarket extends SecondaryIndustry {
    private static final int PRICE = 2;
    private static final int ID = 9;
    private static final CardIcon ICON = CardIcon.FRUIT;

    @Override
    public int getPrice() {
        return PRICE;
    }

    @Override
    public int getId() { return ID; }

    @Override
    public CardIcon getIcon() { return ICON; }

    @Override
    public int getPayout(List<PrimaryIndustry> blues) {
        int numWheat = 0;

        for (PrimaryIndustry card : blues) {
            if (card.getIcon() == CardIcon.WHEAT) {
                numWheat += 1;
            }
        }

        return 2 * numWheat;
    }

    public boolean isActivated(int rollNumber) {

        return rollNumber == 11 || rollNumber == 12;
    }

    public String toString() {
        return "Fruit and Vegetable Market";
    }
}

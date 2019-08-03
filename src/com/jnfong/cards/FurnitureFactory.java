package com.jnfong.cards;

import com.jnfong.player.Player;

import java.util.List;

public class FurnitureFactory extends SecondaryIndustry {
    private static final int PRICE = 3;
    private static final int ID = 8;
    private static final int ACTIVATION_NUM = 8;
    private static final CardIcon ICON = CardIcon.FACTORY;

    @Override
    public int getPrice() {
        return PRICE;
    }

    @Override
    public int getId() { return ID; }

    @Override
    public CardIcon getIcon() { return ICON; }

    @Override
    public int getPayout(List<PrimaryIndustry> blues, Player player) {
        int numGears = 0;

        for (PrimaryIndustry card : blues) {
            if (card.getIcon() == CardIcon.GEAR) {
                numGears += 1;
            }
        }

        return 3 * numGears;
    }

    public boolean isActivated(int rollNumber) {
        return rollNumber == ACTIVATION_NUM;
    }

    public String toString() {
        return "Furniture Factory";
    }
}

package com.jnfong.cards;

import com.jnfong.player.Player;

import java.util.List;

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

    @Override
    public int getPayout(List<PrimaryIndustry> blues, Player player) {
        if (player.hasShoppingMall()) {
            return 2;
        }
        return 1;
    }


    public boolean isActivated(int rollNumber) {
        return rollNumber == 2 || rollNumber == 3;
    }

    public String toString() {
        return "Bakery";
    }
}

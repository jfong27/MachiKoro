package com.jnfong.cards;

import com.jnfong.player.Player;

import java.util.List;

public class CheeseFactory extends SecondaryIndustry {

    private static final int PRICE = 5;
    private static final int ID = 7;
    private static final int ACTIVATION_NUM = 7;
    private static final CardIcon ICON = CardIcon.FACTORY;

    @Override
    public int getPrice() {
        return PRICE;
    }

    @Override
    public int getId() { return ID; }

    @Override
    public CardIcon getIcon() { return ICON; }

    // Payout is 3 coins for every Cow icon card owned.
    @Override
    public int getPayout(List<PrimaryIndustry> blues, Player player) {
        int numCows = 0;

        for (PrimaryIndustry card : blues) {
            if (card.getIcon() == CardIcon.COW) {
                numCows += 1;
            }
        }

        return 3 * numCows;
    }

    public boolean isActivated(int rollNumber) {
        return rollNumber == ACTIVATION_NUM;
    }

    public String toString() {
        return "Cheese Factory";
    }
}

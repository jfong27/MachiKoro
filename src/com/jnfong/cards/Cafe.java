package com.jnfong.cards;

import com.jnfong.player.Player;

public class Cafe extends Restaurant {

    private static final int PRICE = 2;
    private static final int ID = 10;
    private static final int ACTIVATION_NUM = 3;
    private static final int COINS_TO_STEAL = 1;
    private static final CardIcon ICON = CardIcon.CUP;

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
    public int coinsToSteal(Player player) {
        if (player.hasShoppingMall()) {
            return COINS_TO_STEAL + 1;
        }
        return COINS_TO_STEAL;
    }


    public String toString() {
        return "Cafe";
    }
}

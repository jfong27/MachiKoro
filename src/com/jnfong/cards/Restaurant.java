package com.jnfong.cards;

import com.jnfong.player.Player;

public abstract class Restaurant implements Card {
    public int getInitAmount() {
        return 6;
    }
    public int coinsToSteal(Player player) { return 1; }
    public CardIcon getIcon() { return CardIcon.CUP; }
}

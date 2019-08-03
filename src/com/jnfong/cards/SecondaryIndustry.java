package com.jnfong.cards;

import com.jnfong.player.Player;

import java.util.List;

public abstract class SecondaryIndustry implements Card {

    public int getInitAmount() {
        return 6;
    }

    public int getPayout(List<PrimaryIndustry> blues, Player player) {
        return 1;
    }
}

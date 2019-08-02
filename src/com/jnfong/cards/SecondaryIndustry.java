package com.jnfong.cards;

import java.util.List;

public abstract class SecondaryIndustry implements Card {

    public int getInitAmount() {
        return 6;
    }

    public int getPayout(List<PrimaryIndustry> blues) {
        return 1;
    }
}

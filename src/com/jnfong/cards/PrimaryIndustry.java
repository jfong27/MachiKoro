package com.jnfong.cards;

public abstract class PrimaryIndustry implements Card {
    public int getInitAmount() {
        return 6;
    }
    public int getPayout() { return 1; }
}

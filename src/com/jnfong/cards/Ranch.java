package com.jnfong.cards;

public class Ranch extends PrimaryIndustry {

    @Override
    public int getPrice() {
        return 1;
    }

    @Override
    public boolean isActivated(int rollNumber, int playerId) {
        if (rollNumber == 2) { return true; }
        return false;
    }

    @Override
    public int getId() {
        return 1;
    }

    public String toString() { return "Ranch"; }
}

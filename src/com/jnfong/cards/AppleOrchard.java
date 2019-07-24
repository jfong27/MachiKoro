package com.jnfong.cards;

public class AppleOrchard extends PrimaryIndustry {
    @Override
    public int getPrice() {
        return 3;
    }

    @Override
    public int getId() {
        return 4;
    }

    @Override
    public boolean isActivated(int rollNumber, int playerId) {
        if (rollNumber == 10) { return true; }
        return false;
    }

    public String toString() {
        return "Apple Orchard";
    }
}

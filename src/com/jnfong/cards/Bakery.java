package com.jnfong.cards;

public class Bakery extends SecondaryIndustry {

    @Override
    public int getPrice() {
        return 1;
    }

    public boolean isActivated(int rollNumber, int playerId) {
        if (rollNumber == 1) { return true; }
        return false;
    }

    @Override
    public int getId() {
        return 5;
    }

    public String toString() {
        return "Bakery";
    }
}

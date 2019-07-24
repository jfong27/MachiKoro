package com.jnfong.cards;

public class Mine extends PrimaryIndustry {

    @Override
    public int getPrice() {
        return 6;
    }

    @Override
    public int getId() {
        return 3;
    }

    @Override
    public boolean isActivated(int rollNumber, int playerId) {
        if (rollNumber == 9) { return true; }
        return false;
    }

    public String toString() {
        return "Mine";
    }
}

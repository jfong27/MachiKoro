package com.jnfong.cards;

public class Forest extends PrimaryIndustry {

    @Override
    public int getPrice() {
        return 3;
    }

    @Override
    public int getId() {
        return 2;
    }

    @Override
    public boolean isActivated(int rollNumber, int playerId) {
        if (rollNumber == 5) { return true; }
        return false;
    }

    public String toString() {
        return "Forest";
    }
}

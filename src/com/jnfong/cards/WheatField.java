package com.jnfong.cards;

public class WheatField extends PrimaryIndustry {

    @Override
    public int getPrice() {
        return 1;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public boolean isActivated(int rollNumber, int playerId) {
        if (rollNumber == 1) { return true; }
        return false;
    }

    public String toString() {
        return "Wheat Field";
    }
}

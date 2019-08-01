package com.jnfong.board;

import com.jnfong.player.Player;

import java.util.Random;

public class Game {
    private Player[] players;
    private CardStack[] cardStacks;
    private int numPlayers;
    private static final int NUM_CARD_TYPES = 15;
    private static final int MAX_PLAYERS = 4;
    public static final int NUM_LANDMARKS = 4;


    public Game(int numPlayers) {
        this.numPlayers = numPlayers;

        players = new Player[MAX_PLAYERS];

        for (int i = 0; i < numPlayers; i++) {
            players[i] = new Player(i);
        }

        cardStacks = new CardStack[NUM_CARD_TYPES];

        initializeCardStacks();

    }

    /*
     * Game has a field of cards that can be purchased.
     * It consists of 15 stacks of different cards. Each stack
     * has the same cards.
     */
    private void initializeCardStacks() {
        System.out.println("Initializing buyable card decks...");
        for (int i = 0; i < NUM_CARD_TYPES; i++) {
            cardStacks[0] = new CardStack(i);
        }

    }

    /*
     * TODO: To see all activated cards, go through all opponents and see which red cards take effect (order matters).
     *       Pay all debts, then go through all opponents and pay from bank for all activated blue cards.
     *       Finally, check all blue, green, and purple cards for the current player.
     */
    public void playGame() {
        Player currPlayer;
        Random random = new Random();
        int playerTurn = 0;
        int roll;

        int count = 0;

        while (true) {
            System.out.println("Player " + playerTurn + "'s turn");
            currPlayer = players[playerTurn];
            roll = random.nextInt(6) + 1;

            if (currPlayer.hasTrainStation()) {
                System.out.println("Would you like to roll 1 or 2 dice?");
                roll += 1; // TODO: Change to actual roll
            }
            System.out.println("Player " + playerTurn + " rolled a " + roll);
            activateCards(playerTurn, roll);

            playerTurn += 1;
            if (playerTurn == numPlayers) { playerTurn = 0; }
            count += 1;

            if (count > 5) { break; }
        }
    }

    private void activateCards(int currPlayerIndex, int roll) {

        Player currPlayer = players[currPlayerIndex];

        activateRedCards(currPlayerIndex, roll);

        for (Player player : players) {
            player.activateBlue(roll);
        }

        currPlayer.activatePurpleGreen(roll);
    }

    private void activateRedCards(int currPlayerIndex, int roll) {

        Player currOpponent;
        Player currPlayer = players[currPlayerIndex];
        int opponentSteals = 0;
        int oppIndex = currPlayerIndex - 1;

        do {
            currOpponent = players[oppIndex];
            opponentSteals = currOpponent.activateRed(roll);
            transferCoins(currPlayer, currOpponent, opponentSteals);
            oppIndex -= 1;
            if (oppIndex < 0) {
                oppIndex = players.length - 1;
            }
        } while (currPlayer.getNumCoins() > 0 && oppIndex != currPlayerIndex);

    }



    private void transferCoins(Player from, Player to, int amount) {

        if (amount > from.getNumCoins()) {
            amount = from.getNumCoins();
        }
        System.out.println(String.format("Player %s takes %d coins from Player %s",
                                         to.toString(), amount, from.toString()));
        from.takeCoins(amount);
        to.giveCoins(amount);
    }

}

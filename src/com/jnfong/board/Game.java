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

    public void playGame() {
        Player currPlayer;
        Random random = new Random();
        int playerTurn = 0;
        int rollOne;

        int count = 0;

        while (true) {
            System.out.println("Player " + playerTurn + "'s turn");
            currPlayer = players[playerTurn];
            rollOne = random.nextInt(6) + 1;

            if (currPlayer.hasTrainStation()) {
                System.out.println("Would you like to roll 1 or 2 dice?");
            }
            System.out.println("Player " + playerTurn + " rolled a " + rollOne);

            playerTurn += 1;
            if (playerTurn == numPlayers) { playerTurn = 0; }
            count += 1;

            if (count > 5) { break; }
        }
    }
}

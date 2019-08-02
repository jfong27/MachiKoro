package com.jnfong.board;

import com.jnfong.cards.Card;
import com.jnfong.player.Player;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player[] players;
    private CardStack[] cardStacks;
    private int numPlayers;
    private static final int NUM_CARD_TYPES = 15;
    public static final int NUM_LANDMARKS = 4;


    public Game(int numPlayers) {
        this.numPlayers = numPlayers;

        players = new Player[numPlayers];

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
            cardStacks[i] = new CardStack(i);
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
            System.out.println("\nPlayer " + playerTurn + "'s turn");
            currPlayer = players[playerTurn];
            roll = random.nextInt(6) + 1;

            if (currPlayer.hasTrainStation()) {
                System.out.println("Would you like to roll 1 or 2 dice?");
                roll += 0; // TODO: Change to actual roll
            }
            System.out.println("Player " + playerTurn + " rolled a " + roll);
            activateCards(playerTurn, roll);
            allowPurchase(currPlayer);

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

        currPlayer.activateGreen(roll);
        currPlayer.activatePurple(roll);
    }

    private void activateRedCards(int currPlayerIndex, int roll) {

        Player currOpponent;
        Player currPlayer = players[currPlayerIndex];
        int opponentSteals;
        int oppIndex = currPlayerIndex - 1;

        if (oppIndex < 0) {
            oppIndex = players.length - 1;
        }

        do {
            currOpponent = players[oppIndex];
            opponentSteals = currOpponent.activateRed(roll);
            if (opponentSteals > 0) {
                transferCoins(currPlayer, currOpponent, opponentSteals);
            }
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

        if (amount > 0) {
            System.out.println(String.format("%s takes %d coins from %s",
                                             to.toString(), amount, from.toString()));
            from.takeCoins(amount);
            to.giveCoins(amount);
        }
    }

    private void allowPurchase(Player player) {

        System.out.println(String.format("%s: %d coins", player.toString(), player.getNumCoins()));
        System.out.println("Would you like to make a purchase? (y/n)");
        Scanner scanner = new Scanner(System.in);
        String ans = scanner.next();

        int i = 0;
        int purchaseId;
        if (ans.toLowerCase().charAt(0) == 'y') {
            for (CardStack cardStack : cardStacks) {
                System.out.print(i++ + " - ");
                System.out.println(cardStack.toString());
            }
            System.out.print(">> ");
            purchaseId = scanner.nextInt();
            if (player.getNumCoins() >= cardStacks[purchaseId].getCardType().getPrice()) {
                Card newCard = cardStacks[purchaseId].getCard();
                player.giveCard(newCard);
                player.takeCoins(newCard.getPrice());
            }
        }

    }

}

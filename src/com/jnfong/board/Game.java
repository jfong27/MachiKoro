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
     * TODO: Have landmarks take effect
     */
    public void playGame() {
        Player currPlayer;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int playerTurn = 0;
        int roll;

        int count = 0;

        while (true) {
            System.out.println("\nPlayer " + playerTurn + "'s turn");
            currPlayer = players[playerTurn];
            System.out.println(currPlayer.getNumCoins());
            roll = random.nextInt(6) + 1;

            if (currPlayer.hasTrainStation()) {
                System.out.println("Would you like to roll 1 or 2 dice?");
                if (scanner.nextInt() == 2) {
                    roll += random.nextInt(6) + 1;
                }
            }
            System.out.println("Player " + playerTurn + " rolled a " + roll);
            activateCards(playerTurn, roll);
            allowPurchase(currPlayer);
            if (currPlayer.hasWon()) {
                System.out.println(currPlayer.toString() + " has won!");
                break;
            }

            playerTurn += 1;
            if (playerTurn == numPlayers) { playerTurn = 0; }
            count += 1;
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

    //TODO: Allow purchase of Landmarks
    private void allowPurchase(Player player) {

        System.out.println(String.format("%s: %d coins", player.toString(), player.getNumCoins()));
        System.out.println("Would you like to make a purchase? (y/n)");
        Scanner scanner = new Scanner(System.in);
        String ans = scanner.next();

        if (ans.toLowerCase().charAt(0) == 'y') {
            makePurchase(player);

        }

    }

    private void makePurchase(Player player) {
        int purchaseId;
        int i = 0;
        Scanner scanner = new Scanner(System.in);

        for (CardStack cardStack : cardStacks) {
            if (cardStack.getQuantity() > 0) {
                System.out.print(i + " - ");
                System.out.println(cardStack.toString());
            }
            i++;
        }

        if (!player.hasTrainStation()) {
            System.out.println("15 - Train Station Price: 4");
        }
        if (!player.hasShoppingMall()) {
            System.out.println("16 - Train Station Price: 10");
        }
        if (!player.hasAmusementPark()) {
            System.out.println("17 - Train Station Price: 16");
        }
        if (!player.hasRadioTower()) {
            System.out.println("18 - Train Station Price: 22");
        }

        System.out.print(">> ");
        purchaseId = scanner.nextInt();
        if (purchaseId < 15) {
            if (player.getNumCoins() >= cardStacks[purchaseId].getCardType().getPrice()) {
                Card newCard = cardStacks[purchaseId].getCard();
                player.giveCard(newCard);
                player.takeCoins(newCard.getPrice());
            }
        } else if (purchaseId < 19) {
            player.buildLandmark(purchaseId);
        }
    }

}

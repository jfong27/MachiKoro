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

    public void playGame() {
        Player currPlayer;

        int playerTurn = 0;
        int[] rolls;
        int roll;

        while (true) {
            System.out.println("\nPlayer " + playerTurn + "'s turn");
            currPlayer = players[playerTurn];
            rolls = rollDice(currPlayer, true);

            if (rolls[1] > -1) {
                roll = rolls[0] + rolls[1];
            } else {
                roll = rolls[0];
            }
            activateCards(playerTurn, roll);
            allowPurchase(currPlayer);
            if (currPlayer.hasWon()) {
                System.out.println(currPlayer.toString() + " has won!");
                break;
            }

            playerTurn += 1;
            if (currPlayer.hasAmusementPark() && rolls[0] == rolls[1]) {
                playerTurn -= 1;
                System.out.println(currPlayer.toString() + " gets another turn for rolling doubles" +
                                                           " and having an Amusement Park");
            }
            if (playerTurn == numPlayers) { playerTurn = 0; }
        }
    }

    private int[] rollDice(Player player, boolean isFirstRoll) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int[] rolls = new int[2];
        rolls[0] = random.nextInt(6) + 1;
        rolls[1] = -1;

        if (player.hasTrainStation()) {
            System.out.println("Would you like to roll 1 or 2 dice?");
            if (scanner.nextInt() == 2) {
                System.out.println(player.toString() + " rolled a " + rolls[0] + " and " + rolls[1]);
                rolls[1] = random.nextInt(6) + 1;
            } else {
                System.out.println(player.toString() + " rolled a " + rolls[0]);
            }
        } else {
            System.out.println(player.toString() + " rolled a " + rolls[0]);
        }

        if (isFirstRoll && player.hasRadioTower()) {
            System.out.println("Would you like to reroll? (y/n)");
            System.out.print(">> ");
            char ans = scanner.next().toLowerCase().charAt(0);
            if (ans == 'y') {
                return rollDice(player, false);
            }
        }

        return rolls;
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

        printLandmarks(player);

        System.out.print(">> ");
        purchaseId = scanner.nextInt();
        if (purchaseId < 15) {
            if (player.getNumCoins() >= cardStacks[purchaseId].getCardType().getPrice()) {
                Card newCard = cardStacks[purchaseId].getCard();
                player.giveCard(newCard);
                player.takeCoins(newCard.getPrice());
            } else {
                System.out.println("You dont have enough coin");
            }
        } else if (purchaseId < 19) {
            player.buildLandmark(purchaseId);
        }
    }

    private void printLandmarks(Player player) {

        if (!player.hasTrainStation()) {
            System.out.println("15 - Train Station Price: 4");
        }
        if (!player.hasShoppingMall()) {
            System.out.println("16 - Shopping Mall Price: 10");
        }
        if (!player.hasAmusementPark()) {
            System.out.println("17 - Amusement Park Price: 16");
        }
        if (!player.hasRadioTower()) {
            System.out.println("18 - Radio Tower Price: 22");
        }
    }

}

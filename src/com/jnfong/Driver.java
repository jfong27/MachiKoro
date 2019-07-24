package com.jnfong;

import com.jnfong.board.Game;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Game game;
        System.out.println("Welcome to Machi Koro");
        System.out.println("How many players?");
        Scanner scanner = new Scanner(System.in);
        int numPlayers = scanner.nextInt();
        game = new Game(numPlayers);
        game.playGame();



    }
}

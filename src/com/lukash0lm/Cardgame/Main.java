package com.lukash0lm.Cardgame;

import com.lukash0lm.Cardgame.SortingStrategies.Rank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("-----------------------------");
        System.out.println("Luke's Blackjack Game");
        System.out.println("-----------------------------");
        System.out.println();
        System.out.println("How many players?");

        CardHand.sortStrategy = new Rank();

        int numPlayers = scanner.nextInt();
        BlackJack bj = new BlackJack();
        bj.game(numPlayers);

    }
}
package com.lukash0lm.Cardgame;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {

    public void game(int numPlayers) {
        GameManager gm = new GameManager();
        Deck deck = new Deck();
        deck = gm.fillDeck();
        deck.shuffle();

        ArrayList<CardHand> hands = new ArrayList<CardHand>();

        for (int i = 0; i < numPlayers; i++) {
            hands.add(new CardHand());
        }

        for (int i = 0; i < 2; i++) {
            for (CardHand hand : hands) {

                if (deck.contents.isEmpty()) {
                    deck = gm.fillDeck();
                    deck.shuffle();
                }

                hand.addCard(gm.drawCard(deck));
            }
        }

        for (int i = 0; i < hands.size(); i++) {

            hands.get(i).setName("Player " + (i + 1));

            System.out.print(hands.get(i).getName() + ": " + hands.get(i).contents.toString());

            if (hands.get(i).contents.get(0).getRank() + hands.get(i).contents.get(1).getRank() == 21) {
                System.out.print(" BlackJack!");
            }
            System.out.println();
        }

        round(hands, deck, gm);

    }


    public void round(ArrayList<CardHand> hands, Deck deck, GameManager gm) {
        for (CardHand hand : hands
        ) {

            System.out.println(hand.getName() + ": " + hand.contents.toString());

            while (hand.getValue() < 21) {
                System.out.println(hand.getName() + " hit or stay?");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                if (input.equals("hit")) {
                    hand.addCard(gm.drawCard(deck));
                    System.out.println(hand.getName() + ": " + hand.contents.toString() + " " + hand.getValue());

                    if (hand.getValue() > 21) {
                        System.out.println(hand.getName() + " bust!");
                    }

                    if (hand.getValue() == 21) {
                        System.out.println(hand.getName() + " BlackJack!");
                    }

                } else if (input.equals("stay")) {
                    break;
                }


            }
            System.out.println();
        }

        System.out.println("round over");
        chooseWinner(hands);

    }

    public void chooseWinner(ArrayList<CardHand> hands){

        CardHand winner = new CardHand();
        int max = 0;

        for (CardHand hand: hands
             ) {

            if (hand.contents.get(0).getRank() + hand.contents.get(1).getRank() > max){
                max = hand.contents.get(0).getRank() + hand.contents.get(1).getRank();
                winner = hand;
            }

        }

        System.out.printf("%s wins with %d!", winner.getName(), max);

        System.out.println("play again? y/n");

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        if (input.equals("y")){

            game(hands.size());
        } else {
            System.out.println("goodbye");
        }

    }



}

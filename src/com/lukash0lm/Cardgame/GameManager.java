package com.lukash0lm.Cardgame;

import java.util.ArrayList;
import java.util.Collections;

public class GameManager {


    public Deck fillDeck(){

        Deck d = new Deck();

        for (Suit suit : Suit.values()) {
            createSuit(d, suit);
        }

        return d;

    }


    public void createSuit(Deck d, Suit suit){

        for (int i = 1; i <= 13; i++) {
            Card c = new Card(suit, i);
            d.contents.push(c);
        }


    }

    public void dealCards(Deck d, CardHand h){

    }

    public Deck shuffleDeck(Deck d){

        ArrayList<Card> temp = new ArrayList<>();

        while (!d.contents.isEmpty()) {
            temp.add(d.contents.pop());
        }

        Collections.shuffle(temp);

        for (Card card : temp) {
            d.contents.push(card);
        }

        return d;


    }


    public Card drawCard(Deck d) {

        return d.contents.pop();

    }

}

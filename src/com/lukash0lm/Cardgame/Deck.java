package com.lukash0lm.Cardgame;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

public class Deck {

    Deque<Card> contents;

    public Deck(){

       this.contents = new ArrayDeque<Card>();


    }

    public Deck shuffle(){

        Deck d = this;

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


    public Deque<Card> getContents() {

        return this.contents;

    }
}

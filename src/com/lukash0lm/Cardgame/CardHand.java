package com.lukash0lm.Cardgame;

import java.util.ArrayList;
import java.util.LinkedList;

public class CardHand {

    String name;
    ArrayList<Card> contents;

    public static SortStrategy sortStrategy;

    public CardHand(){
        this.contents = new ArrayList<Card>();
    }

    public CardHand(String name){
        this.name = "name";
        this.contents = new ArrayList<Card>();
    }



    public void addCard(Card c){
        contents.add(c);
        this.sort();
    }

    public void sort(){
        sortStrategy.sort(this);
    }

    public ArrayList<Card> getContents(){
        return contents;
    }

    public void setSortStrategy(SortStrategy s){
        this.sortStrategy = s;
    }

    public void setName(String s) {
        this.name = s;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {

        int value = 0;
        int aceCount = 0;


        for (Card card : contents
             ) {

            if (card.getRank() == 1)
                aceCount++;
            else
                value += card.getRank();
        }


        //dosent work for two aces
        for (int i = 0; i < aceCount; i++) {
            if (value + 11 <= 21)
                value += 11;
            else
                value += 1;
        }

        return value;

    }
}

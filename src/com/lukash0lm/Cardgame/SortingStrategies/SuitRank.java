package com.lukash0lm.Cardgame.SortingStrategies;

import com.lukash0lm.Cardgame.Card;
import com.lukash0lm.Cardgame.CardHand;
import com.lukash0lm.Cardgame.Deck;
import com.lukash0lm.Cardgame.SortStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class SuitRank implements SortStrategy {

    @Override
    public CardHand sort(CardHand d) {

        LinkedList<Card> temp = new LinkedList<>();



        d.getContents().sort(Card::compareTo);



        return d;
    }
}
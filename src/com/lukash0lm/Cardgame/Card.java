package com.lukash0lm.Cardgame;

public class Card {


    private final Suit suit;
    private final int rank;

    public Card(Suit suit, int rank){
        this.suit = suit;
        this.rank = rank;
    }

    public int compareTo(Card card) {

        if (this.suit.ordinal() > card.suit.ordinal()) {
            return 1;
        } else if (this.suit.ordinal() < card.suit.ordinal()) {
            return -1;
        }

        return Integer.compare(this.rank, card.rank);

    }

    @Override
    public String toString() {

        if (rank == 1) return "Ace of " + suit.toString().toLowerCase();
        if (rank == 11) return "Jack of " + suit.toString().toLowerCase();
        if (rank == 12) return "Queen of " + suit.toString().toLowerCase();
        if (rank == 13) return "King of " + suit.toString().toLowerCase();

        return rank + " of " + suit.toString().toLowerCase();
    }

    public int getRank() {
        //only works for blackjack
        return Math.min(rank, 10);
    }

    public Suit getSuit() {
        return suit;
    }


}

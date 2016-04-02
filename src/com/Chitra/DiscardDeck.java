package com.Chitra;

import java.util.Stack;

/**
 * Created by chitrakakkar on 3/18/16.
 */
// This class is for the discrad deck ..can reshuffle it in case want to play again
public class DiscardDeck extends Deck
{
    public DiscardDeck()
    {
        this.DeckOfCard = new Stack<Card>();
    }

    public void AddCard(Card card)
    {
       DeckOfCard.add(card);
    }

}

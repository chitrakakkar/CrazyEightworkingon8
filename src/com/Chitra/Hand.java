package com.Chitra;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chitrakakkar on 3/18/16.
 */
public class Hand
{
    protected List<Card> CardsinHand;
    private static final Integer NumberOfCardsInHand = 7;
    public static Deck DeckOfCards = new Deck();
    public static Card PlayedCard;


    //getter and setter
    public List<Card> getCardsinHand() {return CardsinHand;}

    public void setCardsinHand(List<Card> cardsinHand) {CardsinHand = cardsinHand;}

    //constructor;deals 7 card to each player if two players are playing
    public Hand() {
        this.CardsinHand = new ArrayList<Card>();
        for (int i = 0; i < NumberOfCardsInHand; i++) {
            // this.CardsinHand.add(new Deck().DealCard());
            this.CardsinHand.add(DeckOfCards.DealCard());
        }
        this.PlayedCard = DeckOfCards.DealCard();
        if(PlayedCard.Value.equals(8))
        {
            System.out.println("Need to put it back to the stack");
            DeckOfCards.AddCard(PlayedCard);
            this.PlayedCard=DeckOfCards.DealCard();
            System.out.println(PlayedCard);

        }
    }


    // method to print cards in hand
    public String toString()
    {
        return CardsinHand.toString();
    }
    public void RemoveCardFromHand(Card card)
    {
        Integer I =0;
       // System.out.println("hereeeeee");
        Card C = new Card("1_1");
        while (I<this.CardInHandSize())
        {
            C = this.CardsinHand.get(I);
            ///System.out.println(C);
            if ((C.Suit.equals(card.Suit)) && C.Value.equals(card.Value)) {
                //System.out.println("found " + card + " @ " + this.CardsinHand.indexOf(C));
                this.CardsinHand.remove(C);
            }
            I++;

        }
        //System.out.println("now "+CardsinHand);
    }

    public Integer CardInHandSize()
    {
        return CardsinHand.size();
    }
    public Integer CalculateHandTotalPoint(List<Card>CardsinHand)
    {
        int TotalPoint = 0;
        for (Card C:CardsinHand)
        {
            TotalPoint += C.Value;
        }
        return TotalPoint;
    }


}


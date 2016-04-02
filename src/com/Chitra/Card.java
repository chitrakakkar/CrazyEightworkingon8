package com.Chitra;

import java.util.*;

/**
 * Created by chitrakakkar on 3/18/16.
 */
public class Card
{
    // Card's color(Suit) and Number(Value)

    protected String Suit;
    protected Integer Value;
    protected int  DefaultValue=0;

    // constructor
    public Card(String suit, Integer value)
    {
        this.Suit = suit;

        this.Value = value;
    }
    public Card (String S)
    {
        //System.out.println(" H"+Arrays.toString(S.split("_")));
        String suitt  = S.split("_")[0].trim() +"_";
        Integer Rankk = Integer.parseInt(S.split("_")[1].trim());

        this.Suit= suitt;
        this.Value = Rankk;
    }
    //setters and getters
    public Integer getValue() {return Value;}

    public void setValue(Integer value) {Value = value;}

    public String getSuit() {return Suit;}

    public void setSuit(String suit) {Suit = suit;}

    public String toString()
    {
        return this.Suit + this.Value;
    }

    // a method checks if the card is legal to play
    //returns a hashmap with a flag and a card if legal
    public HashMap<Integer,Card> CheckLegalCard(Card card,Card PlayedCard,Player P)
    {
        HashMap<Integer,Card> Test = new HashMap<>();
        Integer Flagg = 1;
        if(card.Value.equals( 8))
        {
            PlayedCard = PickSuit(P,PlayedCard);
            System.out.println("after 8, the new suit is "+ PlayedCard.Suit);
            Flagg=1;
        }
        else if ((card.Value.equals(PlayedCard.Value))||card.Suit.equals(PlayedCard.Suit))
        {
            //System.out.println(P.Name + "legal check passed , not 8");
            PlayedCard.setSuit(card.Suit);
            PlayedCard.setValue(card.Value);
            Flagg=1;

        }

        else {
            //System.out.println("legal check failed");
            Flagg = 0;
        }
        Test.put(Flagg,PlayedCard);
        return Test;
    }
// a method to give user option to choose suit when 8 is played
    public Card PickSuit(Player player,Card CardOnTable) {
        if (player.Name.equals("Human")) {
            String UserInput = "";
            while (true) {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Which suit do you want to choose(Hearts_ /Spades_ /Diamonds_ /Clubs_ ?");
                    UserInput = scanner.next();
                    break;
                } catch (InputMismatchException ime) {
                    System.out.println("Please enter a String");
                }
                }
            CardOnTable.setSuit(UserInput);
            System.out.println("you changed card on table to " + CardOnTable);


        }
        // computer chooses randomly..
        // wanted to make it intelligent by picking the suit which suit computer has max. in its hand
        //version-2
        else
        {
            String[] Suits = {"Hearts_", "Spades_", "Clubs_", "Diamonds_"};
            Random rnd = new Random();
            CardOnTable.setSuit(Suits[rnd.nextInt(Suits.length)]);

            System.out.println(player.Name + " wants  " + CardOnTable.Suit);
        }
        return CardOnTable;

    }
}

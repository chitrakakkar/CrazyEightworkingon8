package com.Chitra;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public  class Main {

    public static DiscardDeck DiscarDdeck = new DiscardDeck();
    //public static Card PlayedCard;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("This is the crazy eight game between a computer and a human player ");
        System.out.println("*******************************************************************");
        System.out.println("Would you be interested in playing with a computer?(Y/N)");
        String UserInput = scanner.nextLine();
        if (UserInput.equalsIgnoreCase("y")) {
            beginGame();
        } else {
            System.out.println("Come whenever you are Interested");
        }
    }

    public static void beginGame() throws Exception {
        // The game begins
        Player HumanPlayer = new Player("Human", new Hand());
        Player ComputerPlayer = new Player("Computer", new Hand());
        System.out.println("Great ! Let the game begin !!!");
        System.out.println("Shuffling and Dealing cards...");
        TimeUnit.MILLISECONDS.sleep(3000);
        System.out.println(HumanPlayer.toString());
        System.out.println("Computer has " + ComputerPlayer.GetPlayerHandSize() + " Cards");
        System.out.println(ComputerPlayer.toString());
        System.out.println("The Current Card Played on the table is " + Hand.PlayedCard);
        //System.out.println(Hand.DeckOfCards.DeckSize());

            while (true)
                // check if you already have a winner
                {
                    if (HumanPlayer.PlayerHand.CardInHandSize() == 0) // HUman won
                    {
                        System.out.println("You Won!!");
                        break;
                    }
                    else if ((ComputerPlayer.PlayerHand.CardInHandSize() == 0)) // computer won
                    {
                        System.out.println("Computer Won!.. Better Luck Next Time");
                        break;
                    }
                    else if (Hand.DeckOfCards.DeckSize() == 0)
                    {
                        // calculate the points and declare winner
                        if (HumanPlayer.PlayerHand.CalculateHandTotalPoint()<ComputerPlayer.PlayerHand.CalculateHandTotalPoint()) {
                            System.out.println("Computer Won!.. Better Luck Next Time");
                        }
                        else{
                            System.out.println("You Won!!");
                        }
                            break;

                    }
                     // continue the game
                    else {
                        HumanPlayer = READCARDForHuman(HumanPlayer);
                        System.out.println("You Played " + DiscarDdeck.DeckOfCard.pop());
                        System.out.println("You got cards " + HumanPlayer.PlayerHand.CardsinHand);

                        ComputerPlayer = COMPUPLAY(ComputerPlayer);
                        System.out.println("Computer Played " + DiscarDdeck.DeckOfCard.pop());
                        //System.out.println("Computer got cards "+ComputerPlayer.PlayerHand.CardsinHand);
                }


            }
        }


    public static Player READCARDForHuman(Player P ) {
        // ask the human which card he wants to play
        Boolean Flag = true;
        Card card1 = new Card("Spades_1");
        while (Flag) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("User Turn : Which Card do you want to play? OR type D to draw");
            String HumanInput = scanner.next();
            if (HumanInput.equalsIgnoreCase("D")) {
                // draw a card
                card1 = Hand.DeckOfCards.DealCard();
                P.PlayerHand.CardsinHand.add(card1);
                System.out.println("you got " + card1);
                System.out.println("Your card set " + P.PlayerHand.CardsinHand);

            }
            else {
                card1 = new Card(HumanInput);
//                Card HumanInput1 = new Card(HumanInput);
                // Validation of Human input
                // added hasmap. the Checlegal card was returining boolean. Modified to Hasmap to update the
                // handsplayed card
                HashMap<Integer,Card> Naam = new HashMap<>();
                Naam = card1.CheckLegalCard(card1, Hand.PlayedCard,P);
                //System.out.println("Naam = " + Naam);
                Integer Mila = 0;
                Mila = (Integer) Naam.keySet().toArray()[0];
                if (Mila==1)
                        //card1.CheckLegalCard(card1, Hand.PlayedCard,P)
                    {// pop the card from your hand
                    P.PlayerHand.RemoveCardFromHand(card1);
                    // update the Played card after 8
                    //Hand.PlayedCard.setSuit(Naam.get(Mila).Suit);

                        System.out.println("Now hand played card is " +Hand.PlayedCard.Suit );
                    // add the played card in Discard card list
                    DiscarDdeck.AddCard(card1);
                        Hand.PlayedCard.setSuit(Naam.get(Mila).Suit);
                        Hand.PlayedCard.setValue(card1.Value);
                    //System.out.println("Your card set "+P.PlayerHand.CardsinHand);
                    Flag = false;
                } else {

                    System.out.println("This is not a legal card, current Hand on table is " +Hand.PlayedCard);
                }
            }

        }
        return P;
    }

    public static Player COMPUPLAY(Player ChOMOO) {
        Boolean Flag = true;
        while (Flag) {
            Integer cc = ChOMOO.PlayerHand.CardInHandSize();
            Card Temp = new Card("1_1");

            for (Card CP : ChOMOO.PlayerHand.CardsinHand) {

                HashMap<Integer,Card> Naam1 = new HashMap<>();
                //System.out.println("Computer is checking "+CP.Suit +CP.Value);
                Naam1 = CP.CheckLegalCard(CP, Hand.PlayedCard,ChOMOO);
                //System.out.println("Naam1 Computer wala = " + Naam1);
                Integer Mila1 = 0;
                Mila1 = (Integer) Naam1.keySet().toArray()[0];
                if (Mila1==1)
                //card1.CheckLegalCard(card1, Hand.PlayedCard,P)
                {
                    //ChOMOO.PlayerHand.RemoveCardFromHand(CP);
                    //Hand.PlayedCard.setSuit(Naam1.get(1).Suit);
                    System.out.println("Computer has " + ChOMOO.GetPlayerHandSize() + " Cards");
                    DiscarDdeck.AddCard(CP);
                    Temp = CP;
                    Hand.PlayedCard.setSuit(Naam1.get(Mila1).Suit);
                    Hand.PlayedCard.setValue(CP.Value);
                    //System.out.println("Comp card set "+ChOMOO.PlayerHand.CardsinHand);
                    Flag = false;
                    break;

                }
            }
            ChOMOO.PlayerHand.RemoveCardFromHand(Temp);
            //System.out.println("tried removing "+ Temp);

            if (Flag)

            {
                if (Hand.DeckOfCards.DeckSize() != 0) {
                    Card card11 = new Card("1_1");
                    card11 = Hand.DeckOfCards.DealCard();
                    ChOMOO.PlayerHand.CardsinHand.add(card11);
                    System.out.println("Computer drew " + card11);
                    //System.out.println("Computer card set " + ChOMOO.PlayerHand.CardsinHand);

                } else {
                    Flag = false;
                    // calculate points
                }
            }


        }
        return ChOMOO;


    }

}


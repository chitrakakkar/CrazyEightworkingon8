package com.Chitra;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by chitrakakkar on 3/18/16.
 */
public class Player
{
    protected String Name;
    protected Hand PlayerHand;

    public Player(String name, Hand Playerhand)
    {
        this.Name = name;
        this.PlayerHand = Playerhand;

    }
    //getter and setters
    public Hand getPlayerHand() {return PlayerHand;}

    public void setPlayerHand(Hand playerHand){PlayerHand = playerHand;}

    public String getName() {return Name;}

    public void setName(String name) {Name = name;}

    @Override
    public String toString()
    {
        return this.Name + " has " + this.PlayerHand.toString();
    }

    public Integer GetPlayerHandSize()
    {
        return PlayerHand.CardsinHand.size();
    }

// Wanted to check if the card thrown is a valid card -version 2
//    public Boolean CheckCardinHand (Card C)
//    {
//
//        if (this.PlayerHand.CardsinHand.equals(C)){
//            System.out.println("you played a valid card");
//            return true;
//        }
//        else
//        {
//            System.out.println("Sorry!!! you played a invalid card");
//
//            return false;
//        }
//    }


}


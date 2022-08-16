package blackjack;

//Walter Hathway
//CS 145
//Lab 4:Card Game
//This program will create and play a game of blackjack with the user.

import java.util.Scanner;
import java.util.Random;
import java.util.Calendar;
import java.util.ArrayList;

public class blackjack {
   static Scanner s = new Scanner(System.in);
   static Calendar cal = Calendar.getInstance();
   static Random r = new Random(cal.getTimeInMillis());
   

  public static void main(String args[])  {
    ArrayList<Integer> cards = drawTwo();     
    
    //Takes the two first cards from the list and then combines their values
    System.out.println("You draw " + cards.get(0) + " and " + cards.get(1) + " giving you a total of " + cardsTotal(cards));

    //if the combined value is 21 then user wins and program closes
    if(cardsTotal(cards) == 21)
    {
      System.out.println("Congratulations, you got a Blackjack!");
      return;
    }

    System.out.println("Press 1 to draw another card. Press 2 to stand");
    playCards(cards);
  }
  
  public static void playCards(ArrayList<Integer> cards)
  {
    int choice = getChoice();
    // If input is 1 then draw a card
    if(choice == 1)
    {
      int newCard = drawCard();
      cards.add(newCard);
      System.out.println("You drew a " + newCard + ".");
      //checks for blackjack
      if(cardsTotal(cards) == 21)
      {
        System.out.println("Congratulations, you got BlackJack!");
        return;
      }
      else if(cardsTotal(cards) > 21)
      {
        System.out.println("You Busted");
        return;
      }
      //uses recursion if you have a score less than 21
      else {
        System.out.println("You currently have " + cardsTotal(cards) + " cards. Press 1 or 2 again");
        playCards(cards);
      }
    }
    //if user chooses to not draw a card prints value
    else {
      System.out.println("Your final score is " + cardsTotal(cards));
      return;
    }
  }

  public static int drawCard()
  {
    //gets next random int and adds 1 to get non 0 number
    int card = r.nextInt(13) + 1;
    //ace is worth 11
    if( card == 1)
    {
      card = 11;
    }
    //face cards are all worth 10
    else if( card > 10)    {
      card = 10;
    }
    return card;
  }
  
  public static int getChoice()
  {
    int choice = 0;
    while(choice != 1 && choice != 2)
    {
      String next = s.next();
      try{
        choice = Integer.parseInt(next);
      }
      catch(Exception e)
      {
        System.out.println("Not a valid input");
      }
    }
    return choice;
  }
    public static int cardsTotal(ArrayList<Integer> cards)
  {
    int total = 0;
    for(int card :cards)
    {
      total += card;
    }
    return total;
  }

  public static ArrayList<Integer> drawTwo()
  {
    ArrayList<Integer> cards = new ArrayList<Integer>();
    for(int i = 0; i < 2; i++)
    {
      cards.add(drawCard());
    }
    return cards;
  }
}

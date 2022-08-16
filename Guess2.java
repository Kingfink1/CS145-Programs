//Walter Hathaway
// Lab 1 - Guessing Game
// 5/18/2022
//This program produes a guessing game that will continue until the correct number is found.

import java.util.*;

public class Guess2 {
//method 1   
// Guessing game where a random number is generated, and the user tries to guess the number. This program will give hints to the user and report the results of the games
   public static void main(String[] args) { 
      final int NUMBER = 100;
      intro(NUMBER);
      Scanner console = new Scanner (System.in);
      Random rand = new Random();
      int bestNumber = 9999; 
      int sum = 0;
      int gameNumber = 0;
      String answer;
      String userInput;
      do {
         int guessNumber = playGame(console, rand, NUMBER);
         sum += guessNumber;
         gameNumber++;
         if (guessNumber < bestNumber) {
            bestNumber = guessNumber;
         }      
         System.out.print("Do you want to play again? ");
         userInput = console.next().toLowerCase();
      } while (userInput.startsWith("y"));
      reportResults(gameNumber, sum, bestNumber, NUMBER); 
   }
   //method 2
   // Introduce the game to the user through the use of a short instruction sequence 
   public static void intro(int NUMBER) {
      System.out.println("This program allows you to play a guessing game.");
      System.out.println ("I will think of a number between 1 and");
      System.out.println (NUMBER+" and will allow you to guess until");
      System.out.println ("you get it. For each guess, I will tell you");
      System.out.println ("whether the right answer is higher or lower");
      System.out.println ("than your guess.");
   }
   //method 3
   // plays the guessing game
   public static int playGame(Scanner console, Random rand, int NUMBER) {
      int mysteryNumber = rand.nextInt(NUMBER)+1;
      System.out.println();
      System.out.println
      ("I'm thinking of a number between 1 and "+ NUMBER + "...");
      int guess;
      int count = 0; 
      do {
         System.out.print("Your guess? ");
         try {
            guess = console.nextInt();
            if (guess > mysteryNumber) {
               System.out.println("It's lower.");
            } else if (guess < mysteryNumber) {
               System.out.println("It's higher.");
            }
            } catch (Exception InputMismatchException) {
            System.out.println("Please enter a valid number");
            guess = console.nextInt();
         }
      count++;
      } while ( guess != mysteryNumber);
      System.out.println("You got it right in " + count + " guesses");
      return count; 
   }
   //method 4
   // reports results to the user
   public static void reportResults (int gameNumber, int sum, int bestNumber, int NUMBER ) {
      System.out.println();
      System.out.println("Overall results:");
      System.out.println("\ttotal games   = " + gameNumber);
      System.out.println("\ttotal guesses = " + sum );
      double adverage = (double)sum/gameNumber;
      System.out.printf("\tguesses/game  = %.1f\n", adverage);
      System.out.println("\tbest game     = "+ bestNumber);
   }

}
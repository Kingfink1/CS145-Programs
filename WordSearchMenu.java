package WordSearch;
//Walter Hathaway
//8/10/22
//CS 145
//This program will create a word search puzzle using user input for search words


import java.util.*;
import java.io.*;

public class WordSearchMenu {
    public static void main(String[] args) throws FileNotFoundException{
        //ensures that the word search is generated
        boolean generated = false;
        Scanner console = new Scanner(System.in);
        String choice;
        //calls other class
        WordSearch search = new WordSearch();
        do{
            printIntro();
            choice = console.next();
            //generates new word search
            if(choice.equals("g")){
                System.out.println("Enter search words one at a time. When finished press \"q\" and Enter");
                String tok = console.next();
                ArrayList<String> wordsAR = new ArrayList<String>();
                do{
                    wordsAR.add(tok);
                    tok = console.next();
                }while(!tok.equals("q"));
                String[] words = new String[wordsAR.size()];
                wordsAR.toArray(words);
                search.generate(words);
                //lets the program know the word search has been created
                generated = true;
                // show the solution to the current word search
            }else if(choice.equals("s")){
                //if program is generated
                if(generated){
                    showSolution(search);
                }
                //prints out word search
            }else if(choice.equals("p")){
                //if program is generated
                if(generated){
                    print(search);
                }
            }
            // ends program is option chosen is q
        }while(!choice.equals("q"));
    }

    // generates starting menu to the user showing options
    public static void printIntro(){
        System.out.println("Welcome to my word search generator!");
        System.out.println("This programs will allow you to generate your own word search puzzle");
        System.out.println("Please select and option:");
        System.out.println("Generate a new word search (g)");
        System.out.println("Print out your word search (p)");
        System.out.println("Show the solution to your word search(s)");
        System.out.println("Quit the prograrm (q)");
    }
    // prints out word search solution
    public static void showSolution(WordSearch ws){
        System.out.println(ws.toSolution());
    }
    // prints out the word search.
    public static void print(WordSearch ws){
        System.out.println(ws);
    }

}
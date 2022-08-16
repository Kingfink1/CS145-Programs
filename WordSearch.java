package WordSearch;
//Walter Hathaway
//8/12/22
//CS 145

import java.util.*;
import java.io.*;


public class WordSearch{
    // creates the grid for the search
    private char[][] grid;
    // creates the solutions for the search
    private boolean[][] sol;
    private String[] words;
    // creates a word search from an array
    public void generate(String[] w){
        for(int i = 0 ; i < w.length ; i++){
            w[i] = w[i].toLowerCase();
        }
        this.words = w;
        char[][] wordChars = setupGrid();
        for(int i = 0 ; i < wordChars.length ; i++){
            placeWord(wordChars, i);
        }
        fillGrid();
    }
    // Creates a word within the grid at a certain point and direction
    private void placeWord(char[][] wordChars, int iter){
        Random rand = new Random();
        // determines direction
        int direction = rand.nextInt(3);
        int[] pos = {0,0};
        if(direction == 0){
            boolean placed = false;
            int attempts = 0;
            // determines location
            while(!placed && attempts < 100){
                pos[0] = rand.nextInt((grid.length-1) - wordChars[iter].length);
                pos[1] = rand.nextInt((grid.length-1) - wordChars[iter].length);
                placed = true;
                for(int u = 0 ; u < wordChars[iter].length ; u++){
                    if(grid[pos[0] + u][pos[1]] != '\u0000' && grid[pos[0] + u][pos[1]] != wordChars[iter][u]){
                        placed = false;
                        break;
                    }
                }
                attempts++;
            }
            if(placed){
                for(int x = 0 ; x < wordChars[iter].length ; x++){
                    grid[pos[0]][pos[1]] = wordChars[iter][x];
                    sol[pos[0]][pos[1]] = true;
                    pos[0]++;
                }
            }
        }else if(direction == 1){
            boolean placed = false;
            int attempts = 0;
            while(!placed && attempts < 100){
                pos[0] = rand.nextInt((grid.length-1) - wordChars[iter].length);
                pos[1] = rand.nextInt((grid.length-1) - wordChars[iter].length);
                placed = true;
                for(int u = 0 ; u < wordChars[iter].length ; u++){
                    if(grid[pos[0]][pos[1] + u] != '\u0000' && grid[pos[0]][pos[1] + u] != wordChars[iter][u]){
                        placed = false;
                        break;
                    }
                }
                attempts++;
            }
            if(placed){
                for(int x = 0 ; x < wordChars[iter].length ; x++){
                    grid[pos[0]][pos[1]] = wordChars[iter][x];
                    sol[pos[0]][pos[1]] = true;
                    pos[1]++;
                }
            }
        }else if(direction == 2){
            boolean placed = false;
            int attempts = 0;
            while(!placed && attempts < 100){
                pos[0] = rand.nextInt((grid.length-1) - wordChars[iter].length);
                pos[1] = rand.nextInt((grid.length-1) - wordChars[iter].length);
                placed = true;
                for(int u = 0 ; u < wordChars[iter].length ; u++){
                    if(grid[pos[0] + u][pos[1] + u] != '\u0000' && grid[pos[0] + u][pos[1] + u] != wordChars[iter][u]){
                        placed = false;
                        break;
                    }
                }
                attempts++;
            }
            if(placed){
                for(int x = 0 ; x < wordChars[iter].length ; x++){
                    grid[pos[0]][pos[1]] = wordChars[iter][x];
                    sol[pos[0]][pos[1]] = true;
                    pos[1]++;
                    pos[0]++;
                }
            }
        }
    }


    // string of the word search solution
    public String toSolution(){
        String result = "";
        for(int i = 0 ; i < grid.length ; i++){
            for(int x = 0 ; x < grid[i].length ; x++){
                if(sol[i][x]){
                    result += " " + grid[i][x] + " ";
                }else{
                    result += " X ";
                }
            }
            result += "\r\n";
        }
        return result;
    }

    // string of word search grid
    public String toString(){
        String result = "";
        for(int i = 0 ; i < grid.length ; i++){
            for(int x = 0 ; x < grid[i].length ; x++){
                result += " " + grid[i][x] + " ";
            }
            result += "\r\n";
        }
        return result;
    }

    public void toFile(File f) throws FileNotFoundException{
        PrintStream fout = new PrintStream(f);
        fout.println(this);
        fout.println(this.toSolution());
    }

    //Breaks up string into array and adjusts size of grid to match numbr and length of words.
    private char[][] setupGrid(){
        char[][] wordChars = new char[words.length][];
        int longest = 8;
        for(int i = 0 ; i < words.length ; i++){
            wordChars[i] = words[i].toCharArray();
            if(wordChars[i].length > longest){
                longest = wordChars[i].length;
            }
        }
        if(words.length > longest){
            longest = words.length;
        }
        this.grid = new char[longest + 4][longest + 4];
        this.sol = new boolean[longest + 4][longest + 4];
        return wordChars;
    }

    // fills in grid with random letters
    private void fillGrid(){
        for(int i = 0 ; i < grid.length ; i++){
            for(int x = 0 ; x < grid[i].length ; x++){
                Random rand = new Random();
                if(grid[i][x] == '\u0000'){
                    grid[i][x] = (char)(rand.nextInt(26)+97);
                }
            }
        }
    }
}
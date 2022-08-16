//Walter Hathaway
//7/26/22
//Lab 3: Letter Inventory
//CS 145
// This program will keep an inventory of the letters of the alphabet

import java.util.*;

public class LetterInventory {

    // The total number of elements
    private final int INVENTORY_LENGTH = 26;
    private int[] inventory;
    private int size;

    //Constructs a letter inventory from a string input
    public LetterInventory(String data) {
        this.inventory = new int[INVENTORY_LENGTH];
        this.size = 0;
        data = data.toLowerCase();

        for (int i = 0; i < data.length(); i++) {
            char letterAtIndexOf = data.charAt(i);
            if (letterAtIndexOf >= 'a' && letterAtIndexOf <= 'z') {
                this.inventory[letterAtIndexOf - 'a']++;
                this.size++;
            }
        }
    }

    // Converts input to lower case
    private int getElementLocation(char letter) {
        return Character.toLowerCase(letter) - 'a';
    }

    public int size() {
        return this.size;
    }

    // Determines when an inventory is populated (true is empty).
    public boolean isEmpty() {
        return this.size == 0;
    }

    // Throws an exception when an non alphabetic character is entered
    public int get(char letter) {
        this.determineLegality(letter, 0);
        return this.inventory[this.getElementLocation(letter)];
    }

    // Combines 2 inventories into a new one and returns it.
    public LetterInventory add(LetterInventory other) {
        LetterInventory combinedLetterInventorys = new LetterInventory("");
        for (int i = 0; i < INVENTORY_LENGTH; i++) {
            combinedLetterInventorys.inventory[i] = this.inventory[i] +
                    other.inventory[i];
        }
        combinedLetterInventorys.size = this.size() + other.size();
        return combinedLetterInventorys;
    }

    public LetterInventory subtract(LetterInventory other) {
        LetterInventory combinedLetterInventorys = new LetterInventory("");
        for (int i = 0; i < INVENTORY_LENGTH; i++) {
            if ((this.inventory[i] - other.inventory[i]) < 0) {
                return combinedLetterInventorys = null;
            }
            combinedLetterInventorys.inventory[i] = this.inventory[i] -
                    other.inventory[i];

        }
        combinedLetterInventorys.size = this.size() - other.size();
        return combinedLetterInventorys;
    }


    public String toString() {
        String printString = "[";
        if(!this.isEmpty()){
            for (int i = 0; i < INVENTORY_LENGTH; i++) {
                for (int j = 0; j < this.inventory[i]; j++) {
                    printString += (char) ('a' + i);
                }
            }
        }
        return printString += "]";
    }

    // Confirms that the character is a correct argument
    private void determineLegality (char letter, int value){
        if (value < 0) {
            throw new IllegalArgumentException("The value must be greater than"
                    + " or equal to zero. Value: " + value);
        }
        if ((letter < 'A' || letter > 'Z') && (letter < 'a' || letter > 'z')) {
            throw new IllegalArgumentException(letter + " is not a valid "
                    + "alphabetic character.");
        }
    }
}
//Walter Hathaway
//7/25/22
//Assignment 2: PhoneBook
//CS 145
//This program will record and store contact information in a LinkedList

import java.util.*;

public class PhoneBookManager {
    static LinkedList list = new LinkedList();
    //menu
    public static void menu() {

        System.out.println("User Menu:");
        System.out.println("New Contact");
        System.out.println("Current Contacts");
        System.out.println("Search by Contact name");
        System.out.println("Edit Contact name");
        System.out.println("Edit Contact phone #");
        System.out.println("exit");
    }

    public static void menuTop(PhoneBookNode entry) {
        Scanner menuScan = new Scanner(System.in);
        String usersChoice = menuScan.next();
        if (usersChoice.equals("New")) {
            optionOne(menuScan);
        } else if (usersChoice.equals("Current")) {
            optionTwo();
        } else if (usersChoice.equals("Search")) {
            optionThree(menuScan, entry);
        } else if (usersChoice.equals("Edit Name")) {
            System.out.println("New Name");
        } else if (usersChoice.equals("Edit #")) {
            System.out.println("New Number");
        } else if (usersChoice.equals("e")) {
            optionExit();
        } else {
            System.out.println("Incorrect Option Chosen - try again");
        }
    }

    //Takes user input to add and change contact information
    public static void optionOne(Scanner menuScan) {
        int index = 0;
        index++;
        System.out.println("Enter First Name: ");
        String firstname = menuScan.next();
        System.out.println("Enter Last Name: ");
        String lastname = menuScan.next();
        System.out.println("Enter City: ");
        String city = menuScan.next();
        System.out.println("Enter Phone Number: ");
        String number = menuScan.next();
        String fullName = firstname + " " + lastname;
        PhoneBookNode entry = new PhoneBookNode(firstname, lastname, fullName,
                city, number);
        entry.addmidend(firstname, lastname, fullName, city, number);

        //linked list
        list.add(entry);
        System.out.println();
        System.out.println(entry.toString());
        System.out.println("Contact Added");
        System.out.println();
    }
    //prints out everything in the list
    public static void optionTwo() {

        System.out.println(list);
    }

    //searches for contact using user input
    public static void optionThree(Scanner menuScan, PhoneBookNode entry) {
        System.out.println("How would you like to search?");
        int indexLookup = menuScan.nextInt();
        System.out.println(list.get(indexLookup));
        System.out.println("What is the Contacts first name?");
        String firstNameSearch = menuScan.next();
        System.out.println("What is the Contacts last name?");
        String lastNameSearch = menuScan.next();
        String fullNameSearch = firstNameSearch + " " + lastNameSearch;

        if (entry.fullName.equals(fullNameSearch)) {

            System.out.println("Wonderful! We have found the person you're looking for");
            System.out.println(fullNameSearch);
        } else {

            System.out.println("Sorry. We found no one of that name in this phonebook.");

        }
        System.out.println("Try Again y/n?");
        String tryAgain = menuScan.next();
        if (tryAgain.equalsIgnoreCase("yes")) {
            optionThree(menuScan, entry);
        }
        System.out.println("Going back to menu\n");

        menu();
        menuTop(entry);
    }
    //Goodbye Message
    public static void optionExit() {

        System.out.println("Phone Book Closing.");
    }
}


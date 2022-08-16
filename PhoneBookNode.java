//Walter Hathaway
//7/25/22
//Assignment 2: Phone Book
//CS 145

public class PhoneBookNode
{
    public String city;
    public String index;
    public String phonenumber;
    public PhoneBookNode next;
    public PhoneBookNode front;
    public String firstname;
    public String lastname;
    public String fullName;


    public PhoneBookNode(String firstname, String lastname, String fullName,
                         String city, String phonenumber, PhoneBookNode next)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.fullName = fullName;
        this.city = city;
        this.phonenumber = phonenumber;
        this.index = index;
        this.next = next;
    }
    //generates a new node to store information
    public PhoneBookNode(String firstname, String lastname, String fullName,
                         String city, String phonenumber)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.fullName = fullName;
        this.city = city;
        this.phonenumber = phonenumber;
        this.index = index;
        this.next = next;

    }
    //Generates an empty node
    public void PhoneBooknode()
    {

        front = null;
        this.firstname = firstname;
        this.lastname = lastname;
        this.fullName = fullName;
        this.city = city;
        this.phonenumber = phonenumber;
        this.index = index;
        this.next = next;


    }

    //Generates a node to store information and create next node

    public void addmidend(String firstname, String lastname, String fullName,
                          String city, String number)
    {


        this.firstname = firstname;
        this.lastname = lastname;
        this.fullName = fullName;
        this.city = city;
        this.phonenumber = number;
        this.index = index;
        this.next = next;

        if (front == null)
        {

            front = new PhoneBookNode(firstname, lastname, fullName, city,
                    number, next);

        }
        else
        {

            PhoneBookNode current = front;

            while(current.next != null)
            {
                current = current.next;
            }

            current.next = new PhoneBookNode(firstname, lastname,
                    fullName, city, number, next);
        }

    }

    public String toString()
    {

        String fullName = firstname +" "+ lastname;
        return "\n\nIndex Location:" + index + "\n" + "Full name: " +
                fullName +"\n" + "City: " + city + "\n" + "Phone Number: " + phonenumber +
                "\n\n";
    }

}

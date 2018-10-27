package com.agaskaw;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();
    private static Contact contact = new Contact();


    public static void main(String[] args) {


        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice:");
            choice=scanner.nextInt();
            switch (choice) {
                case 0:
                    printInstructions();
                    break;

                case 1:
                    mobilePhone.printContactsList();
                    break;
                case 2:
                    System.out.println("Name: ");
                    String name = scanner.next();
                    System.out.println("Number: ");
                    String number = scanner.next();
                    Contact newContact =new Contact(name, number);
                    System.out.println(newContact.getName());
                    mobilePhone.addContact(newContact);
                    System.out.println(newContact.getName() + " added.");
                    break;
                case 3:
                    System.out.println("Which contact would you like to modify?");
                    String nameToModify = scanner.next();
                    Contact contactToModify = mobilePhone.findByName(nameToModify);
                    System.out.println("Found: " + contactToModify.getName() + ", " + contactToModify.getNumber());
                    System.out.print("Please enter new name:");
                    String newName = scanner.next();
                    System.out.print("Please enter new number:");
                    String newNumber = scanner.next();
                    Contact contactToBeStored = contact.createContact(newName, newNumber);
                    mobilePhone.modifyContact(contactToModify, contactToBeStored);
                    System.out.println("Modified contact stored");
                    break;
                case 4:
                    System.out.println("Enter contact to be removed:");
                    String nameToRemove = scanner.next();
                    Contact contactToBeRemoved = mobilePhone.findByName(nameToRemove);
                    System.out.println("Found " + contactToBeRemoved.getName() + ", tel. " + contactToBeRemoved.getNumber());
                    System.out.println("Delete? Y/N");
                    String choice2 = scanner.next();
                    if ("Y".equals(choice2)) {
                        mobilePhone.removeContact(contactToBeRemoved);
                        System.out.println("Contact " + contactToBeRemoved.getName() + " deleted.");
                    } else if ("N".equals(choice2)) {
                        System.out.println("No contact was deleted.");
                    } else {
                        System.out.println("Invalid input.");
                    }
                    break;
                case 5:
                    System.out.println("Enter name:");
                    String nameToBeFound = scanner.next();
                    Contact contactToBeFound = mobilePhone.findByName(nameToBeFound);
                    System.out.println("Found " + contactToBeFound.getName() + ", tel. " + contactToBeFound.getNumber());
                    break;

                case 6:
                    quit = true;
                    break;


            }


        }


    }

    public static void printInstructions(){
        System.out.println("Choose option:");
        System.out.println("\t 0 - menu");
        System.out.println("\t 1 - print contact list");
        System.out.println("\t 2 - add contact");
        System.out.println("\t 3 - modify conatct");
        System.out.println("\t 4 - remove contact");
        System.out.println("\t 5 - find contact");
        System.out.println("\t 6 - quit");

    }
}



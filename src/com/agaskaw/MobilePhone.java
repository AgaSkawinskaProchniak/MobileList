package com.agaskaw;

import java.util.ArrayList;

public class MobilePhone{

    private ArrayList<Contact> contactsList;


    public MobilePhone() {
        this.contactsList = new ArrayList<Contact>(); //its better to initialize in constructor
    }

    public void printContactsList(){
        System.out.println("You have "+contactsList.size()+" contacts:");
        for(int i =0; i<contactsList.size();i++){
            System.out.println(i+1+". "+contactsList.get(i).getName()+", phone number: "+contactsList.get(i).getNumber());
        }

    }

    public void addContact(Contact contact){
        contactsList.add(contact);
    }

    public void removeContact(Contact contact){
        int position =contactsList.indexOf(contact);
        if(position>=0){
            contactsList.remove(position);
        }

    }

    public void findContact(Contact contact){
        int position = contactsList.indexOf(contact);
        if(position>=0){
            System.out.println(contact+"found at "+position+1);
        }

    }

    public void modifyContact(Contact contact,Contact newContact){
        int position  =contactsList.indexOf(contact);
        contactsList.set(position,newContact);
    }

    public Contact findByName(String name){
        for(Contact contact:contactsList){
            if(contact.getName().equals(name)){
                return contact;
            }
        }
        return null;
    }



}

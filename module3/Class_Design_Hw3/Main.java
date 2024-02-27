//CS211S Class Design HW
//Gevilee Mari and Jacky Choi
//This program tests the Character Class Design OOP

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        int input;
        String name;
        int level;
        int health;
        int attackCharges;
        String type;
        ArrayList<Character> characterList = new ArrayList<>();

        System.out.println("Welcome to Character Creation Simulator!");
        System.out.print("Testing purposes: Would you like to start off with some default characters? (y,n): ");
        String inputStart;
        inputStart = scnr.nextLine();
        if(inputStart.equalsIgnoreCase("y")) {
            characterList.add(Character.addCharacter(Character.CharacterType.ARCHER, "Parissa", 50, 986, 2));
            characterList.add(Character.addCharacter(Character.CharacterType.MAGE, "Tamoki", 33, 215, 2));
            characterList.add(Character.addCharacter(Character.CharacterType.WARRIOR, "Tamoki", 32, 1198, 2));
            System.out.println("Characters added!");
            System.out.print("Press (enter/return) key to continue: ");
            scnr.nextLine();
            System.out.println();
        }
        
        do {
            System.out.println("What would you like to do?: ");
            System.out.println("1: Display all Characters and their details.");
            System.out.println("2: Add a Character.");
            System.out.println("3: Sort all Characters by Name.");
            System.out.println("4: Sort all Characters by Level.");
            System.out.println("5: Sort all Characters by Name and Level!");
            System.out.println("6: Exit");
            System.out.print("Please enter your selection: ");
            input = scnr.nextInt();

            switch(input) {
                case 1:
                    System.out.println("These are all your current chracters: ");
                    System.out.println("___________________________________________________ ");
                    for (Character character : characterList) {
                        character.displayCharacter();
                        System.out.println();
                    }
                    System.out.println();
                
                   
                    break;
                case 2:
                    Character.CharacterType classType;
                    scnr.nextLine();
                
                    System.out.print("Class Type (Archer, Mage, or Warrior): ");
                    type = scnr.nextLine();
                    while(!type.equalsIgnoreCase("archer") && !type.equalsIgnoreCase("mage") && !type.equalsIgnoreCase("warrior")) {
                        System.out.print("The class " + type + " does not exist. Please enter (Archer, Mage, or Warrior): ");

                        type = scnr.nextLine();
                    }

                    if(type.equalsIgnoreCase("archer")) {
                        classType = Character.CharacterType.ARCHER;
                    }
                    else if (type.equalsIgnoreCase("mage")) {
                        classType = Character.CharacterType.MAGE;
                    }
                    else if (type.equalsIgnoreCase("warrior")) {
                        classType = Character.CharacterType.WARRIOR;
                    }
                    else {
                        throw new IllegalArgumentException("Type does mot exist: " + type);
                    }
                    

                    System.out.print("Character Name: ");
                    name = scnr.nextLine();
                    System.out.print("Level: ");
                    level = scnr.nextInt();
                    System.out.print("Health: ");
                    health = scnr.nextInt();
                    System.out.print("Starting Attack Charges: ");
                    attackCharges = scnr.nextInt();
                    if(attackCharges > 5) {
                        System.out.println("Attack charges defaulted to 5. 5 is the max!");
                        attackCharges = 5;
                    }
                    else if(attackCharges < 0) {
                        System.out.println("Attack charges defaulted to 0. 0 is the minimum!");
                        attackCharges = 0;
                    }
                    characterList.add(Character.addCharacter(classType, name, level, health, attackCharges));
                    System.out.println("Character Added.");
                  
                    System.out.println();
                    break;

                case 3:
                    if(characterList.size() != 0) {
                        System.out.println("These are your characters sorted by name: ");
                        //M3 USING Comparator
                        Collections.sort(characterList, new Character.NameComparator());
                        for (Character character : characterList) {
                            System.out.println(character);
                        }
                        System.out.println();
                    }
                    else {
                        System.out.println("Your list is empty.");
                       
                    }
                 
                    System.out.println();
                    break;

                case 4:
                    if(characterList.size() != 0) {
                        System.out.println("These are your characters sorted by level: ");
                        //M3 USING Comparator
                        Collections.sort(characterList, new Character.LevelComparator());
                        for (Character character : characterList) {
                            System.out.println(character);
                        }
                        System.out.println();
                    }
                    else {
                        System.out.println("Your list is empty.");
                       
                    }
                  
                    System.out.println();
                    break;
                
                case 5:
                    if(characterList.size() != 0) {
                        System.out.println("These are your characters sorted by name and level: ");
                        
                        Collections.sort(characterList, new Character.NameLevelComparator());
                        for (Character character : characterList) {
                            System.out.println(character);
                        }
                        System.out.println();
                    }
                    else {
                        System.out.println("Your list is empty.");
                    }
                  
               
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Terminating all creations.");
                    break;
                default:
                    System.out.println("Please choose a number 1 - 6");

            }
        } while (input != 6);
        scnr.close();
    }
}

/*
Changes:
2/09 replace == with .equalsIgnoreCase to compare strings
2/10 Fix toString methods on all child classes to use super.toString() properly.
2/10 Refactor control flow for attack charges check to remove Java compiler warnings in all classes
2/10 Module 2 HW: Add Static Method and Comparable Method to Character.java
2/10 Add Factory method
2/16 Add Enum and Comparator 
2/16 Implement Enum to factory method
2/17 Update Comparator for name and level
2/18 update Driver Design for User Input
2/19 Clean up code
2/19 Create and use a enum method in character display
*/
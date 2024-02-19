//CS211S Class Desgin HW
//Jacky Choi

//This program tests the Character Class Design OOP
// Create an array or list using the parent class as the declared type.
// Fill with several different child objects.
// Invoke at least two methods on the objects. (If the method exists only in the child class, use instanceof and a downcast.)

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
*/

import java.util.ArrayList;
import java.util.Collections; //Added for Collections.sort with Comparable implementation
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

       
        Scanner scnr = new Scanner(System.in);
        int input;
        ArrayList<Character> characterList = new ArrayList<>();

        System.out.println("Welcome to Character Creation Simulator!");
        
        do {
            System.out.println("What would you like to do?: ");
            System.out.println("1: Display all Characters.");
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
                    for (Character character : characterList) {
                        System.out.println(character);
                    }
                    System.out.println();
                    System.out.println("Enter any key to continue: ");
                    System.console().readLine();
                    break;
                case 2:
                    String name;
                    int level;
                    int health;
                    int attackCharges;
                    String type;

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

                    //M3 USING ENUM 
                    characterList.add(Character.addCharacter(classType, name, level, health, attackCharges));
                    System.out.println("Character Added.");
                    break;

                case 3:
                    if(characterList.size() != 0) {
                        System.out.println("These are your characters sorted by name: ");
                        //M3 USINH Comparator
                        Collections.sort(characterList, new Character.NameComparator());
                        for (Character character : characterList) {
                            System.out.println(character);
                        }
                        System.out.println();
                    }
                    else {
                        System.out.println("Your list is empty.");
                       
                    }
                    System.out.println("Enter any key to continue: ");
                    System.console().readLine();
                    break;

                case 4:
                    if(characterList.size() != 0) {
                        System.out.println("These are your characters sorted by level: ");
                        Collections.sort(characterList, new Character.LevelComparator());
                        for (Character character : characterList) {
                            System.out.println(character);
                        }
                        System.out.println();
                    }
                    else {
                        System.out.println("Your list is empty.");
                       
                    }
                    System.out.println("Enter any key to continue: ");
                    System.console().readLine();
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
                    System.out.println("Enter any key to continue: ");
                    System.console().readLine();
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
Sample Output
jackychoi@Jackys-MacBook-Pro Class_Design_Hw % javac Main.java
jackychoi@Jackys-MacBook-Pro Class_Design_Hw % java Main      
Static method should get the total number of characters created: 5

Before sort is called to sort by level:
Val Level: 1 Health: 10 Attack Charges: 2 Energy: 3
Tav Level: 5 Health: 25 Attack Charges: 2 Energy: 3
Aloy Level: 10 Health: 44 Attack Charges: 2 Energy: 3
Cab Level: 6 Health: 18 Attack Charges: 2 Mana: 3
Abb Level: 3 Health: 7 Attack Charges: 2 Mana: 3

After sort is called to sort by level:
Val Level: 1 Health: 10 Attack Charges: 2 Energy: 3
Abb Level: 3 Health: 7 Attack Charges: 2 Mana: 3
Tav Level: 5 Health: 25 Attack Charges: 2 Energy: 3
Cab Level: 6 Health: 18 Attack Charges: 2 Mana: 3
Aloy Level: 10 Health: 44 Attack Charges: 2 Energy: 3

Adding a few characters using factory method: 
Printing out full list after creating classes with factory method: 
Val Level: 1 Health: 10 Attack Charges: 2 Energy: 3
Abb Level: 3 Health: 7 Attack Charges: 2 Mana: 3
Tav Level: 5 Health: 25 Attack Charges: 2 Energy: 3
Cab Level: 6 Health: 18 Attack Charges: 2 Mana: 3
Aloy Level: 10 Health: 44 Attack Charges: 2 Energy: 3
Nak Level: 5 Health: 20 Attack Charges: 2 Energy: 5
Pat Level: 22 Health: 112 Attack Charges: 2 Energy: 5
Ban Level: 12 Health: 114 Attack Charges: 2 Energy: 5
jackychoi@Jackys-MacBook-Pro Class_Design_Hw % 
 */

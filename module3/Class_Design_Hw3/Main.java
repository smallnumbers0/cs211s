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
*/

import java.util.ArrayList;
import java.util.Collections; //Added for Collections.sort with Comparable implementation

public class Main {
    public static void main(String[] args) {
        Warrior war1 = new Warrior("Val", 1, 10, 2, 3);
        Warrior war2 = new Warrior("Tav", 5, 25, 2, 3);
        Archer archer1 = new Archer("Aloy", 10, 44, 2, 3);
        Mage mage1 = new Mage("Cab", 6, 18, 2, 3);
        Mage mage2 = new Mage("Abb", 3, 7, 2, 3);

        ArrayList<Character> characterList = new ArrayList<>();
        characterList.add(war1);
        characterList.add(war2);
        characterList.add(archer1);
        characterList.add(mage1);
        characterList.add(mage2);

        System.out.print("Static method should get the total number of characters created: ");
        System.out.println(Character.getNumCharacters());
        System.out.println();

        System.out.println("Before sort is called to sort by level:");
        for (Character character : characterList) {
            System.out.println(character);
        }
        System.out.println();

        Collections.sort(characterList); //This should sort by level defined by compareTo 

        System.out.println("After sort is called to sort by level:");
        for (Character character : characterList) {
            System.out.println(character);
        }
        System.out.println();

        //M2 Using Factory Method
        System.out.println("Adding a few characters using factory method: ");
        Character archer2 = Character.addCharacter("archer", "Nak", 5, 20, 2);
        Character archer3 = Character.addCharacter("archer", "Pat", 22, 112, 2);
        Character war3 = Character.addCharacter("warrior", "Ban", 12, 114, 2);

        characterList.add(archer2);
        characterList.add(archer3);
        characterList.add(war3);

        System.out.println("Printing out full list after creating classes with factory method: ");
        for (Character character : characterList) {
            System.out.println(character);
        }
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

//CS211S Class Desgin HW
//Jacky Choi

//This program tests the Character Class Design OOP
// Create an array or list using the parent class as the declared type.
// Fill with several different child objects.
// Invoke at least two methods on the objects. (If the method exists only in the child class, use instanceof and a downcast.)

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Warrior war1 = new Warrior("Val", 1, 10, 2, 3);
        Warrior war2 = new Warrior("Tav", 5, 25, 2, 3);
        Archer archer1 = new Archer("Aloy", 10, 44, 2, 3);
        Mage mage1 = new Mage("Cab", 6, 18, 2, 3);



        ArrayList<Character> characterList = new ArrayList<>();
        characterList.add(war1);
        characterList.add(war2);
        characterList.add(archer1);
        characterList.add(mage1);


        for(Character character: characterList) {
            
            if(character instanceof Warrior) {
                System.out.println(((Warrior)character).toString());
                ((Warrior)character).specialAttack();
            }
            if(character instanceof Archer) {
                System.out.println(((Archer)character).toString());
                ((Archer)character).specialAttack();
            }
            if(character instanceof Mage) {
                System.out.println(((Mage)character).toString());
                ((Mage)character).specialAttack();
            }
        }

        System.out.println("Aloy has " + archer1.getAttackCharges() + " attack charges.");
        System.out.println("Val has " + war1.getAttackCharges() + " attack charges.");
        System.out.println("Tav has " + war2.getAttackCharges() + " attack charges.");
        war1.attack();
        war1.attack();
        //System.out.println("I have 2 war1.attack() calls but it did not increase attackCharges and I'm not sure why");
        System.out.println("Val has " + war1.getAttackCharges() + " attack charges.");
        war1.specialDefense();
        System.out.println("Val has " + war1.getAttackCharges() + " attack charges.");
    }
}

/*
Sample Output
jackychoi@Jackys-MacBook-Pro Class_Design_Hw % javac Main.java
jackychoi@Jackys-MacBook-Pro Class_Design_Hw % java Main      
Val Level: 1 Health: 10 Attack Charges: 2 Energy: 3
Val swings their blade with extreme precision
Tav Level: 5 Health: 25 Attack Charges: 2 Energy: 3
Tav swings their blade with extreme precision
Aloy Level: 10 Health: 44 Attack Charges: 2 Energy: 3
Aloy fires 3 arrows in quick succession!
Cab Level: 6 Health: 18 Attack Charges: 2 Mana: 3
Cab shoots an infinite amount of energy!
Aloy has 0 attack charges.
Val has 0 attack charges.
Tav has 0 attack charges.
Val charges at the enemy!
Val charges at the enemy!
Val has 2 attack charges.
Val holds up their shield!
Val has 1 attack charges.
jackychoi@Jackys-MacBook-Pro Class_Design_Hw % 
 */

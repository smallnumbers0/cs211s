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
        System.out.println("Val has " + war1.getAttackCharges() + " attack charges.");
    }
}

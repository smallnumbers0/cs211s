//CS211S Class Design HW
//Gevilee Mari and Jacky Choi
//Children class

public class Warrior extends Character {
    private int energy;
    public static int DEFAULT_ENERGY = 5;

    public Warrior(String name, int level, int health, int attackCharges, CharacterType characterType, int energy) {
        super(characterType, name, level, health, attackCharges);
        this.energy = energy;
    }

    public Warrior(String name, int level, int health, int attackCharges, CharacterType characterType) {
        super(characterType, name, level, health, attackCharges);
        this.energy = DEFAULT_ENERGY;
    }

    @Override
    public void attack() {
        System.out.println(super.getName() + " charges at the enemy!");
        if(attackCharges >= 0 && attackCharges < 5) {
            attackCharges++;
        }
        if(energy >= 0 && energy <= 10) {
            energy++;
        }
    }

    public void specialAttack() {
        if(attackCharges >=2) {
            System.out.println(super.getName() + " swings their blade with extreme precision");
            attackCharges -= 2;
            energy++;
        }
        else {
            System.out.println("Ability Failed. not enough attack charges");
        }
    }
        

    public void specialDefense() {
        if(attackCharges >= 1) {
            System.out.println(super.getName() + " holds up their shield!");
            attackCharges--;
            energy--;
        }
        else {
            System.out.println("Defense Failed");
        }
    }

    public void ultimateAttack() {
        if(attackCharges == 5 && energy == 10) {
            System.out.println(super.getName() + " summons 100 energy swords to attack!");
            attackCharges -= 5;
            energy -= 10;
        }
        else {
            System.out.println("Ultimate Attack failed!");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " Energy: " + energy;
    }
}


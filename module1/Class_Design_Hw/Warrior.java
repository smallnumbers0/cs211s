//CS211S Class Design HW
//Jacky Choi
//Children class

public class Warrior extends Character {
    private int energy;
    public Warrior(String name, int level, int health, int attackCharges, int energy) {
        super(name, level, health, attackCharges);
        this.energy = energy;
    }

    @Override
    public void attack() {
        System.out.println(super.getName() + " charges at the enemy!");
        if(attackCharges == 5) {
            attackCharges = attackCharges;
        }
        else {
            attackCharges++;
        }
        if(energy == 10) {
            energy = energy;
        }
        else {
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
        return super.getName() + " " + "Level: " + super.getLevel() + " Health: " + super.getHealth() + " Attack Charges: " + attackCharges + " Energy: " + energy;
    }
}


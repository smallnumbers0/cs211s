//CS211S Class Design HW
//Jacky Choi
//Children class
public class Archer extends Character {

    private int energy;
    public static int DEFAULT_ENERGY = 5;

    public Archer(String name, int level, int health, int attackCharges, int energy) {
        super(name, level, health, attackCharges);
        this.energy = energy;
    }

    public Archer(String name, int level, int health, int attackCharges) {
        super(name, level, health, attackCharges);
        this.energy = DEFAULT_ENERGY;
    }

    @Override
    public void attack() {
        System.out.println(super.getName() + " fires an arrow!");
        if(attackCharges >= 0 && attackCharges < 5) {
            attackCharges++;
        }
        if(energy >= 0 && energy <= 10) {
            energy++;
        }
    }

    public void specialAttack() {
        if(attackCharges >=2) {
            System.out.println(super.getName() + " fires 3 arrows in quick succession!");
            attackCharges -= 2;
            energy++;
        }
        else {
            System.out.println("Ability Failed");
        }
    }

    public void specialDefense() {
        if(attackCharges >= 1) {
            System.out.println(super.getName() + " uses wind energy to create a barrier!");
            attackCharges--;
            energy--;
        }
        else {
            System.out.println("Defense Failed");
        }
    }

    public void ultimateAttack() {
        if(attackCharges == 5 && energy == 10) {
            System.out.println(super.getName() + " summons 100 energy arrows and 1 final energy bolt to attack!");
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

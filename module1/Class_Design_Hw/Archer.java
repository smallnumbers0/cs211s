public class Archer extends Character {
    private int energy;

    public Archer(String name, int level, int health, int attackCharges, int energy) {
        super(name, level, health, attackCharges);
        this.energy = energy;
    }

    @Override
    public void attack() {
        System.out.println(super.getName() + " fires an arrow!");
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
        return super.getName() + " " + "Level: " + super.getLevel() + " Health: " + super.getHealth() + " Attack Charges: " + attackCharges + " Energy: " + energy;
    }
}

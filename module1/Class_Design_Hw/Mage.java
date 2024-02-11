//CS211S Class Design HW
//Jacky Choi
//Children class

public class Mage extends Character {

    private int mana;
    public Mage(String name, int level, int health, int attackCharges, int mana) {
        super(name, level, health, attackCharges);
        this.mana = mana;
    }

    @Override
    public void attack() {
        System.out.println(super.getName() + " shoots a small burst of energy!");
        if(attackCharges <= 5) {
            attackCharges = attackCharges;
        }
        else {
            attackCharges++;
        }
    }

    public void specialAttack() {
        if(attackCharges >=2) {
            System.out.println(super.getName() + " shoots an infinite amount of energy!");
            attackCharges -= 2;
        }
        else {
            System.out.println("Not enough energy!");
        }
    }

    public void specialDefense() {
        if(attackCharges >= 1) {
            System.out.println(super.getName() + " is invulnerable to the next attack!");
            attackCharges--;
        }
        else {
            System.out.println("Not enough energy!");
        }
    }

    public void ultimateAttack() {
        if(attackCharges >= 5) {
            System.out.println(super.getName() + " reduces their health and mana to 1 and explodes causing lots of damage!");
            health = health * 0 + 1;
            mana = mana * 0 + 1;
            attackCharges -= 5;
        }
        else {
            System.out.println("Not enough energy!");
        }
    }

    @Override
    public String toString() {
        return super.getName() + " " + "Level: " + super.getLevel() + " Health: " + super.getHealth() + " Attack Charges: " + attackCharges + " Mana: " + mana;
    }
}

//CS211S Class Design HW
//Gevilee Mari and Jacky Choi
//Children class

public class Mage extends Character {

    private int mana;
    
    public static int DEFAULT_MANA = 1;

    public Mage(String name, int level, int health, int attackCharges, CharacterType characterType, int mana) {
        super(characterType, name, level, health, attackCharges);
        this.mana = mana;
    }

    public Mage(String name, int level, int health, int attackCharges, CharacterType characterType) {
        super(characterType, name, level, health, attackCharges);
        this.mana = DEFAULT_MANA;
    }

    @Override
    public void attack() {
        System.out.println(super.getName() + " shoots a small burst of energy!");
        if(attackCharges >= 0 && attackCharges < 5) {
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
        return super.toString() + " Mana: " + mana;
    }
}

//CS211S Class Design HW
//Jacky Choi
//Parent class


public abstract class Character implements Comparable<Character> {
    private String name;
    private int level;
    protected int health;
    protected int attackCharges;

    private static int numCharacters; //keep track of total number of characters created

    public Character (String name, int level, int health, int attackCharges) {
        this.name = name;
        this.level= level;
        this.health = health;
        this.attackCharges = attackCharges;

        Character.numCharacters++;

    }

    //M2 creating Factory MEthod
    public static Character addCharacter(String type, String name, int level, int health, int attackCharges) {
        if(type.equalsIgnoreCase("Archer")) {
    		return new Archer(name, level, health, attackCharges);
    	} 
        else if(type.equalsIgnoreCase("Warrior")) {
    		return new Warrior(name, level, health, attackCharges);
        }
        else if(type.equalsIgnoreCase("Mage")) {
            return new Mage(name, level, health, attackCharges);
    	} else {
    		throw new IllegalArgumentException(type + " class type does not exist.");
    	}
    }

    public enum levelBonus {
        BRONZE, SILVER, GOLD
    }



    //M2 HOMEWORK STATIC
    public static int getNumCharacters() {
        return Character.numCharacters;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level; 
    }

    public int getHealth() {
        return health; 
    }

    public int getAttackCharges() {
        return attackCharges; 
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttackCharges(int attackCharges) {
        this.attackCharges = attackCharges;
    }

    public void attack() {
        System.out.println(name + " does a basic attack!");
        attackCharges++;
    }

    public void defend() {
        System.out.println(name + " braces for the next attack!");
    }

    public void runAway() {
        System.out.println(name + " runs for their life!");
    }


    //M2 Comparable to define sorting characters by level 
    @Override
	public int compareTo(Character c) {
		return Integer.compare(level,  c.level); 
	}

    @Override
    public String toString() {
        return name + " " + "Level: " + level + " Health: " + health + " Attack Charges: " + attackCharges;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Character otherCharacter 
            && this.name.equalsIgnoreCase(otherCharacter.name)
            && this.level == otherCharacter.level;
    }
}


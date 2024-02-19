//CS211S Class Design HW
//Jacky Choi
//Parent class
import java.util.Comparator;

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

    //M3 HOMEOWRK ENUM USE in addition to this factory method by taking in an enum Character Type instead of String
    //M2 creating Factory MEthod
    //Class and Character Type is kind of like a same context right now before I kind of sort things out properly between them.
    public static Character addCharacter(CharacterType type, String name, int level, int health, int attackCharges) {
        if(type == CharacterType.ARCHER) {
    		return new Archer(name, level, health, attackCharges);
    	} 
        else if(type == CharacterType.MAGE) {
    		return new Mage(name, level, health, attackCharges);
        }
        else if(type == CharacterType.WARRIOR) {
            return new Warrior(name, level, health, attackCharges);
    	} else {
    		throw new IllegalArgumentException(type + " class type does not exist.");
    	}
    }
    //After using and testing this in main, I'm not sure if this is even a good way to use enums.

    //M3 HOMEWORK ENUM
    public enum CharacterType {
        ARCHER("Archer"), MAGE("Mage"), WARRIOR("Warrior");

        private String type;

        private CharacterType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "Character Class: " + type;
        }
    }

    //M3 Comparator HW
    public static final Comparator<Character> NAME_COMPARATOR = new NameComparator();
    public static class NameComparator implements Comparator<Character> {
        public int compare(Character chr1, Character chr2) {
            return chr1.name.compareToIgnoreCase(chr2.name);
        }
    }

    public static final Comparator<Character> LEVEL_COMPARATOR = new LevelComparator();
    public static class LevelComparator implements Comparator<Character> {
        public int compare(Character chr1, Character chr2) {
            return Integer.compare(chr1.level, chr2.level);
        }
    }

    //M3 Comparator HW updated
    public static final Comparator<Character> NAME_LEVEL_COMPARATOR = new NameLevelComparator();
    public static class NameLevelComparator implements Comparator<Character> {
        public int compare(Character chr1, Character chr2) {
            if(!(chr1.name.equalsIgnoreCase(chr2.name))) {
                return chr1.name.compareToIgnoreCase(chr2.name);
            }
            else {
                return Integer.compare(chr1.level, chr2.level);
            }
        }
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


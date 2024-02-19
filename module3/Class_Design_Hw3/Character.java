//CS211S Class Design HW
//Gevilee Mari and Jacky Choi
//Parent class
import java.util.Comparator;

public abstract class Character implements Comparable<Character> {
    private String name;
    private int level;
    protected int health;
    protected int attackCharges;
    //ENUM USE
    private CharacterType characterType;
    private static int numCharacters; 


    public Character (CharacterType characterType, String name, int level, int health, int attackCharges) {
        this.name = name;
        this.level= level;
        this.health = health;
        this.attackCharges = attackCharges;
        this.characterType = characterType;
        Character.numCharacters++;
    }

    public static Character addCharacter(CharacterType characterType, String name, int level, int health, int attackCharges) {
        if(characterType == CharacterType.ARCHER) {
    		return new Archer(name, level, health, attackCharges, characterType);
    	} 
        else if(characterType == CharacterType.MAGE) {
    		return new Mage(name, level, health, attackCharges, characterType);
        }
        else if(characterType == CharacterType.WARRIOR) {
            return new Warrior(name, level, health, attackCharges, characterType);
    	} else {
    		throw new IllegalArgumentException(characterType + " class type does not exist.");
    	}
    }
    //After using and testing this in main, I'm not sure if this is even a good way to use enums. Maybe Ill try making a enum for weapons next for different classes

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

    public CharacterType getCharacterType() {
        return characterType;
    }

    //M3 Comparator HW Name
    public static final Comparator<Character> NAME_COMPARATOR = new NameComparator();
    public static class NameComparator implements Comparator<Character> {
        public int compare(Character chr1, Character chr2) {
            return chr1.name.compareToIgnoreCase(chr2.name);
        }
    }
    //M3 Comparator Hw Level
    public static final Comparator<Character> LEVEL_COMPARATOR = new LevelComparator();
    public static class LevelComparator implements Comparator<Character> {
        public int compare(Character chr1, Character chr2) {
            return Integer.compare(chr1.level, chr2.level);
        }
    }

    //M3 Comparator HW Name and then Level
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

    //M3 HOMEWORK ENUM METHOD USE as a return type.
    public void displayCharacter() {
        System.out.println("Name: " + name);
        System.out.println(getCharacterType());
        System.out.println("Level: " + level);
        System.out.println("Health " + health);
        System.out.println("Attack Charges " + attackCharges + "/5");
    }

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


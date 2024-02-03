
public abstract class Character {
    private String name;
    // protected String name; 
    private int level;
    protected int health;
    protected int attackCharges;

    public Character (String name, int level, int health, int attackCharges) {
        this.name = name;
        this.level= level;
        this.health = health;
        this.attackCharges = attackCharges;
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

    @Override
    public String toString() {
        return name + " " + "Level: " + level + "Health: " + health + "Attack Charges: " + attackCharges;
    }

    // @Override
    // public boolean equals(Object obj) {
    //     if(obj instanceof Character) {
    //         Character otherCharacter = (Character) obj;
    //         String otherCharacterName = otherCharacter.name;
    //         int otherCharacterLevel = otherCharacter.level;

    //         if(name == otherCharacterName && level == otherCharacterLevel) {
    //             return true;
    //         }
    //         else {
    //             return false;
    //         }
    //     }
    //     else {
    //         return false;
    //     }
    // }

    //pattern matching is pretty cool
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Character otherCharacter 
            && this.name == otherCharacter.name 
            && this.level == otherCharacter.level;
    }
}


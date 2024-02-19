public class WeaponItem extends StoreItem {

    private int attack;
    public WeaponItem(String name, int price, StatusBoost status, int attack) {
        super(name, price, status);
        this.attack = attack;
    }

}
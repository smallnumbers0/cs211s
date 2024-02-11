

public class VanillaIceCream extends IceCreamOrder {
    private int vanillaTax;

    private static int totalTaxCollected = 0;

    public static final int BASE_PRICE = 10;
    public static final int BASE_TAX = 5;

    public VanillaIceCream(String name, int price, int amount, int vanillaTax) {
        super(name, price, amount);
        this.vanillaTax = vanillaTax; //Sorry for being so not creative
        VanillaIceCream.totalTaxCollected += this.vanillaTax;
    }

    public static int getTotalTax() {
        return VanillaIceCream.totalTaxCollected;
    }
    public VanillaIceCream(String name, int price, int amount) {
        this(name, BASE_PRICE, amount, BASE_TAX);
    }

    public VanillaIceCream(String name, int vanillaTax) {
        super(name);
        this.vanillaTax = vanillaTax;
    }

    public VanillaIceCream(String name) {
        this(name, BASE_TAX);
    }
}

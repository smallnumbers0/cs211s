//Module 2: adding static

public class IceCreamOrder {
    private String name;
    private int price;
    private int amount;

    private static int numOrders = 0;

    public static final int BASE_PRICE = 2;
    public static final int BASE_AMOUNT = 1;

    public IceCreamOrder(String name, int price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;

        IceCreamOrder.numOrders++;
    }

    public IceCreamOrder( String name, int price) {
        this(name, price, BASE_AMOUNT);
    }

    public IceCreamOrder(String name) {
        this(name, BASE_AMOUNT);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static int getTotalOrders() {
        return numOrders;
    }

    @Override
    public String toString() {
        return name + "Cost per scoop: $" + price;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof IceCreamOrder) {
            IceCreamOrder otherStore = (IceCreamOrder) obj;

            return otherStore.name.equalsIgnoreCase(name) && otherStore.price == price;
        }
        else {
            return false;
        }
    }

    public void sell() {
        System.out.println("A scoop of original Ice Cream Sold! + $" + price * amount);
    }

    public void giveSample() {
        System.out.println("Giving a free sample of original flavor!");
    }
}

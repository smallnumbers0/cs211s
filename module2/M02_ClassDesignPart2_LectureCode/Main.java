

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<IceCreamOrder> list = new ArrayList<>();
        


        list.add(new VanillaIceCream("Lan", 5, 5, 6));
        list.add(new VanillaIceCream("Van", 18));
        list.add(new VanillaIceCream("Ben", 12));
        list.add(new VanillaIceCream("Rall", 11));

        System.out.println("Total Vanilla tax: " + VanillaIceCream.getTotalTax());
    }
}

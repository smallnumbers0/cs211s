//This program is a Store Inventory class using OOP practices 
//Jacky Choi CS211s

import java.util.Comparator;
import java.util.Random;

public abstract class StoreItem implements Comparable<StoreItem>{
    private String name;
    private int price;
    private StatusBoost status;

    public static final int DEFAULT_PRICE = 0;

    //Static Variable
    public static int totalStoreItems = 0;
        
    public enum StatusBoost {
        NORMAL(false, "Normal"), SHINY(true, "Shiny");
    
        private boolean status;
        private String displayStatus;
    
        private StatusBoost(boolean status, String displayStatus) {
            this.status = status;
            this.displayStatus = displayStatus;
        }
    
        public boolean ItemStatus() {
            return status;
        }
    
        @Override
        public String toString() {
            return "This is a " + displayStatus + " item";
        }
    }

    public StoreItem(String name, int price, StatusBoost status) {
        this.name = name;
        this.price = price;
        this.status = status;
        StoreItem.totalStoreItems++;
    }

    public StoreItem(String name, StatusBoost status) {
        this(name, DEFAULT_PRICE, status);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    //Static Method
    public static int getTotalStoreItems() {
        return StoreItem.totalStoreItems;
    }

    public StatusBoost getItemStatus() {
        return status;
    }

    @Override
    public String toString() {
        return name + ": " + price;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof StoreItem) {
            StoreItem other = (StoreItem) obj;
            return this.name.equalsIgnoreCase(other.name) && this.price == other.price;
        }
        else {
            return false;
        }
    }

    @Override public int compareTo(StoreItem item) {
        return Integer.compare(price, item.price);
    }
}
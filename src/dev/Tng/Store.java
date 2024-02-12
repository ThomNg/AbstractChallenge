package dev.Tng;

import java.util.ArrayList;

record OrderItem (int qty, ProductForSale product){}

public class Store {

    private static ArrayList <ProductForSale> storeProducts = new ArrayList<>();

    public static void main(String[] args) {

        storeProducts.add(new DisplayObject("Pokemon Karmesin & Purpur", 140, "Japan collector edition"));
        storeProducts.add(new DisplayObject("Pokemon Scarlet & Violet", 130, "Germany collector edition"));
        storeProducts.add(new BoosterObject("Sun & Moon argimond", 20, "Remix but - SM11a"));
        storeProducts.add(new BoosterObject("Schwert & Schild Sturmwind", 24, "Deutsch- SM232a"));

        listProducts();

        System.out.println("\nOrder 1:");
        var order1 = new ArrayList<OrderItem>();
        addItemToOrder(order1, 0, 2);
        addItemToOrder(order1, 1, 4);
        printOrder(order1);

        System.out.println("\nOrder 2:");
        var order2 = new ArrayList<OrderItem>();
        addItemToOrder(order2, 3, 3);
        addItemToOrder(order2, 2, 2);
        addItemToOrder(order2, 1, 5);
        printOrder(order2);

    }

    public static void listProducts (){
        for (var item: storeProducts) {
            System.out.println("-".repeat(30));
            item.showDetails();
        }
    }

    public static void addItemToOrder(ArrayList<OrderItem> order, int orderIndex, int qty){
        order.add(new OrderItem(qty, storeProducts.get(orderIndex)));
    }

    public static void printOrder(ArrayList<OrderItem> order){
        double totalSales = 0;
        for (var item: order) {
            item.product().printPricedItem(item.qty());
            totalSales += item.product().getSalesPrice(item.qty());
        }
        System.out.printf("Sales total = $%6.2f %n", totalSales);
    }
}

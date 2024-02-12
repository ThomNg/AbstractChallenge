package dev.Tng;

public class DisplayObject extends ProductForSale{

    public DisplayObject(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.println("This "+type+ " is a Pokemon display");
        System.out.printf("The price of the piece is $%6.2f %n", price);
        System.out.println(description);
    }
}

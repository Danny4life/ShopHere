package org.cashier;

import org.storeEnum.Gender;
import org.storeEnum.Position;

public class Receipts extends Cashier{

    public Receipts(String name, String phoneNumber, Position position, String emailAddress, Gender gender) {
        super(name, phoneNumber, position, emailAddress, gender);
    }

    public  static void issueReceipt(String name, String item, Double price, Integer quantity, Integer wallet) {
        System.out.println();
        System.out.println("Hello " + " " + name + " " + "your purchased of" + " " + item + " " + "MOBILE" + " " + "with  quantity," + " " +
                quantity + ", " + "is successful!");
        System.out.println("Please hold for your receipt: " + "\n" +
                "Amount in Wallet = " + " " + wallet +  "$" + "\n" +
                "Cost of Item = " + " " + ((price * quantity)) + "$" + "\n" +
                "Balance = " + " " + (wallet - (price * quantity)) + "$");
        System.out.println("Thanks for your patronage!");
        System.out.println();
    }
}

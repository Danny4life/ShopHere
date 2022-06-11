package org.cashier;

import org.customer.Customers;
import org.models.Products;
import org.models.Staff;
import org.models.Store;
import org.customer.CustomerOrder;
import org.buy.BuyTo;
import org.storeEnum.Gender;
import org.storeEnum.Position;

import java.io.IOException;
import java.util.*;

public class Cashier extends Staff implements CashierActivity {
    public Cashier(String name, String phoneNumber, Position position, String emailAddress, Gender gender) {
        super(name, phoneNumber, position, emailAddress, gender);
    }



    @Override
    public void sellingViaPriorityQueue(List<CustomerOrder> customerOrders, Store store) throws IOException {
        List<Products> productStore = store.getItems();
        LinkedList<CustomerOrder> newCustomerOrderList = store.getNewCustomerOrderList();

        for(int i = 0; i < newCustomerOrderList.size(); i++) {
            for (int j = 0; j < productStore.size(); j++) {
                if((!productStore.get(j).getProductName().equals(newCustomerOrderList.get(i).getItem()))) {
                    continue;
                }

                if(productStore.get(j).getProductName().equals(newCustomerOrderList.get(i).getItem())) {
                    if (productStore.get(j).getQuantity() < newCustomerOrderList.get(i).getQuantity()) {
                        System.out.println("OUT OF STOCK!");
                    }
                    else if (productStore.get(j).getQuantity() > 0) {
                        productStore.get(j).setQuantity(productStore.get(j).getQuantity() - newCustomerOrderList.get(i).getQuantity());
                        Receipts.issueReceipt(newCustomerOrderList.get(i).getName(), productStore.get(j).getProductName(),
                                productStore.get(j).getPrice(), newCustomerOrderList.get(i).getQuantity(), newCustomerOrderList.get(i).getWallet());
                    }
                }
            }
        }
    }






    @Override
    public boolean sellProduct(BuyTo buyTo, Customers customer) {
        if ((customer.getWallet() >= buyTo.getTotalAmountOfAvailableItems()) && this.getPosition()==(Position.JUNIOR_STAFF)) {
            System.out.println("Hello " + " " + customer.getName() + "," + " your purchase of " + " " + buyTo.getItemsAvailable()
                    + " " + " has been successful! Please hold on while we print your receipt.");
            return true;
        } else {
            throw new RuntimeException("Insufficient funds");
        }
    }


    @Override
    public void issueReceipt(BuyTo buyTo, Customers customer) {
        if ((customer.getWallet() == buyTo.getTotalAmountOfAvailableItems()) && this.getPosition()==(Position.JUNIOR_STAFF)) {
            System.out.println("Here is your receipt: " + "\n" +
                    "Wallet = " + " " + customer.getWallet() + "\n" +
                    "Item Cost = " + " " + buyTo.getTotalAmountOfAvailableItems() + "\n" +
                    "Balance = " + " " + (customer.getWallet() - buyTo.getTotalAmountOfAvailableItems()));
        }
        else if ((customer.getWallet() > buyTo.getTotalAmountOfAvailableItems()) && this.getPosition()==(Position.JUNIOR_STAFF)) {
            System.out.println("Here is your receipt: " + "\n" +
                    "Wallet = " + " " + customer.getWallet() + "\n" +
                    "Item Cost = " + " " + buyTo.getTotalAmountOfAvailableItems() + "\n" +
                    "Balance = " + " " + (customer.getWallet() - buyTo.getTotalAmountOfAvailableItems()));
        }
        else {
            throw new RuntimeException("Insufficient Balance");
        }
    }
}

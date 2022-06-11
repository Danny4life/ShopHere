package org.models;

import org.cashier.Receipts;
import org.customer.CustomerOrder;

import java.util.*;


public class MultiThreadSales implements Runnable {

    CustomerOrder customerOrder;

    public MultiThreadSales(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }


    public void sellToCustomer() {

        List<Products> productStore = Store.getItems();

        for (int j = 0; j < productStore.size(); j++) {


            if(productStore.get(j).getProductName().equals(customerOrder.getItem())) {
                if (productStore.get(j).getQuantity() < customerOrder.getQuantity()) {
                    System.out.println("OUT OF STOCK!");
                }
                else if (productStore.get(j).getQuantity() > 0) {
                    productStore.get(j).setQuantity(productStore.get(j).getQuantity() - customerOrder.getQuantity());
                    Receipts.issueReceipt(customerOrder.getName(), productStore.get(j).getProductName(),
                            productStore.get(j).getPrice(), customerOrder.getQuantity(), customerOrder.getWallet());
                }
            }
        }

    }


    @Override
    public synchronized void run() {
        sellToCustomer();
    }


    @Override
    public String toString() {
        return "ThreadSales{" +
                "customerOrder=" + customerOrder +
                '}';
    }
}

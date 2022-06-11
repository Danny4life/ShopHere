package org.cashier;

import org.customer.CustomerOrder;
import org.customer.Customers;
import org.models.Store;
import org.buy.BuyTo;

import java.io.IOException;
import java.util.List;


public interface CashierActivity {
    boolean sellProduct (BuyTo buyTo, Customers customer);

    void issueReceipt(BuyTo buyTo, Customers customer);

    void sellingViaPriorityQueue (List<CustomerOrder> customerOrders, Store store) throws IOException;
}

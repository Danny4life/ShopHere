package org.customer;

import org.models.Store;
import org.buy.BuyTo;

import java.util.ArrayList;

public interface CustomerActivity {
    BuyTo customerCartSummary(ArrayList<String>  customerList, Store store);
}

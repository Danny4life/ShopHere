package org.buy;

import java.util.List;

public class BuyTo {

    private String customerName;
    private List<String> itemsAvailable;
    private List<String> itemsNotAvailable;
    private Double totalAmountOfAvailableItems;

    public BuyTo() {
    }

    public BuyTo(String customerName, List<String> itemsAvailable, List<String> itemsNotAvailable, Double totalAmountOfAvailableItems) {
        this.customerName = customerName;
        this.itemsAvailable = itemsAvailable;
        this.itemsNotAvailable = itemsNotAvailable;
        this.totalAmountOfAvailableItems = totalAmountOfAvailableItems;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<String> getItemsAvailable() {
        return itemsAvailable;
    }

    public void setItemsAvailable(List<String> itemsAvailable) {
        this.itemsAvailable = itemsAvailable;
    }

    public List<String> getItemsNotAvailable() {
        return itemsNotAvailable;
    }

    public void setItemsNotAvailable(List<String> itemsNotAvailable) {
        this.itemsNotAvailable = itemsNotAvailable;
    }

    public Double getTotalAmountOfAvailableItems() {
        return totalAmountOfAvailableItems;
    }

    public void setTotalAmountOfAvailableItems(Double totalAmountOfAvailableItems) {
        this.totalAmountOfAvailableItems = totalAmountOfAvailableItems;
    }

    @Override
    public String toString() {
        return "PurchaseDto{" +
                "customerName='" + customerName + '\'' +
                ", itemsAvailable=" + itemsAvailable +
                ", itemsNotAvailable=" + itemsNotAvailable +
                ", totalAmountOfAvailableItems=" + totalAmountOfAvailableItems +
                '}';
    }
}

package org.customer;

import org.models.Products;
import org.models.Store;
import org.buy.BuyTo;
import org.storeEnum.Gender;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customers implements CustomerActivity {

    ArrayList<Products> customerList = new ArrayList<>();
    ArrayList<String> customerCartOfItems = new ArrayList<>();


    private String name;
    private String phoneNumber;
    private Gender gender;
    private String emailAddress;

    private double wallet;


    public Customers(String name, String phoneNumber, Gender gender, String emailAddress, double wallet) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.emailAddress = emailAddress;
        this.wallet = wallet;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getCustomerCartOfItems() {
        return customerCartOfItems;
    }

    public double getWallet() {
        return wallet;
    }

    public ArrayList<Products> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(ArrayList<Products> customerList) {
        this.customerList = customerList;
    }

    @Override
    public BuyTo customerCartSummary(ArrayList<String>  customerList, Store store) {
        List<Products> itemsInStore = store.getItems();
        Double totalOfAvailableItems = 0.00;
        List<String> itemsNotAvailable = new ArrayList<>();
        List<String> itemsToBuy = new ArrayList<>();
        BuyTo buyTo = new BuyTo();

        for(int i=0; i<itemsInStore.size(); i++){
            for(int j=0; j<customerList.size(); j++) {

                if(Objects.equals(itemsInStore.get(i).getProductName(), customerList.get(j))){
                    if(itemsInStore.get(i).getQuantity()<=0) {
                        itemsNotAvailable.add(customerList.get(j));
                    } else {
                        itemsToBuy.add(itemsInStore.get(i).getProductName());
                        totalOfAvailableItems+=itemsInStore.get(i).getPrice();
                        itemsInStore.get(i).setQuantity(itemsInStore.get(i).getQuantity()-1);
                    }
                }
            }
        }
        buyTo.setCustomerName(this.name);
        buyTo.setItemsAvailable(itemsToBuy);
        buyTo.setItemsNotAvailable(itemsNotAvailable);
        buyTo.setTotalAmountOfAvailableItems(totalOfAvailableItems);

        return buyTo;
    }


    @Override
    public String toString() {
        return "Customers{" +
                "customerList=" + customerList +
                ", customerCartOfItems=" + customerCartOfItems +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender=" + gender +
                ", emailAddress='" + emailAddress + '\'' +
                ", wallet=" + wallet +
                '}';
    }
}

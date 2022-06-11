package org.customer;

public class CustomerOrder implements Comparable<CustomerOrder>{
    private String name;

    private String item;

    private int quantity;

    private int wallet;


    public CustomerOrder() {
    }

    public CustomerOrder(String name, String item, int quantity, int wallet) {
        this.name = name;
        this.item = item;
        this.quantity = quantity;
        this.wallet = wallet;
    }

    public String getName() {
        return name;
    }

    public String getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getWallet() {
        return wallet;
    }

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "name='" + name + '\'' +
                ", item='" + item + '\'' +
                ", quantity=" + quantity +
                ", wallet=" + wallet +
                '}';
    }

    @Override
    public int compareTo(CustomerOrder customerOrder) {
        if(customerOrder.item != this.item)
        {
            return 1;
        }
        else  {
            if (customerOrder.quantity > this.quantity) {
                return 1;
            }
            else if (customerOrder.quantity == this.quantity) {
                return 1;
            }
            else{
                return -1;
            }
        }
    }
}

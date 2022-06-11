package org;

import org.cashier.Cashier;
import org.customer.CustomerOrder;
import org.fileReader.ReadFromCSVFile;
import org.storeManager.Manager;
import org.models.Products;
import org.models.Store;
import org.models.MultiThreadSales;
import org.storeEnum.Gender;
import org.storeEnum.Position;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        // Instantiating the Manager class
        Manager manager = new Manager("John", "123-456-789", Position.SENIOR_STAFF,
                "John@gmail.com", Gender.MALE);

        // Instantiating the Product class
        Products product = new Products("TECHNO", 20.20, 10);
        Products product1 = new Products("SONY", 5.10, 6);
        Products product2 = new Products("IPHONE", 10.00, 5);
        Products product3 = new Products("S22ULTRA", 10.00, 5);
        Products product4 = new Products("GOOGLE", 10.00, 5);



        System.out.println();
        System.out.println("************************Read items to store***************************");
        ReadFromCSVFile readFromCSVFile = new ReadFromCSVFile();
        System.out.println(readFromCSVFile.fileReader());
        System.out.println("Store size: " + readFromCSVFile.fileReader().size());

        System.out.println();

        // Instantiating Store
        Store store = new Store();

        System.out.println("***************Products update by manager********************");
        manager.updateProduct(product);
        manager.updateProduct(product1);
        manager.updateProduct(product2);
        manager.updateProduct(product3);
        manager.updateProduct(product4);

        System.out.println();

//        System.out.println("*******************Items in Store After Manager Updated***********************");
//        System.out.println(store.getItems());
//        System.out.println("Store size " + store.getItems().size());


        // Instantiating the Cashier class
        Cashier cashier = new Cashier("Jane", "222-333-444", Position.JUNIOR_STAFF,
                "jane@gmail.com", Gender.FEMALE);


        System.out.println();

        CustomerOrder newCustomerOne = new CustomerOrder("Joe", "TECHNO",3, 300);
        CustomerOrder newCustomerTwo = new CustomerOrder("Jane", "TECHNO",2, 220);
        CustomerOrder newCustomerThree = new CustomerOrder("Doe", "TECHNO",4, 550);
        CustomerOrder newCustomerFour = new CustomerOrder("Mitch", "TECHNO",1, 180);


        LinkedList<CustomerOrder> customerOrderList = new LinkedList<>();
        customerOrderList.add(newCustomerOne);
        customerOrderList.add(newCustomerTwo);
        customerOrderList.add(newCustomerThree);
        customerOrderList.add(newCustomerFour);


        Collections.sort(customerOrderList);

        Thread threadOne = new Thread(new MultiThreadSales(newCustomerOne));
        Thread threadTwo = new Thread(new MultiThreadSales(newCustomerTwo));
        Thread threadThree = new Thread(new MultiThreadSales(newCustomerThree));
        Thread threadFour = new Thread(new MultiThreadSales(newCustomerFour));



        threadOne.start();
        Thread.sleep(2000);

        threadTwo.start();
        Thread.sleep(2000);

        threadThree.start();
        Thread.sleep(2000);

        threadFour.start();
        Thread.sleep(2000);


        //System.out.println("After customer purchase " + store.getItems());

    }
}

import domain.Client;
import domain.Order;
import domain.Product;
import domain.Status;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Product pr1 = new Product("cup",5, 100);
//        Product pr2 = new Product("table",100, 50);
//        Product pr3 = new Product("mirror",30, 15);
//        Product pr4 = new Product("fridge",200, 10);
//        Product pr5 = new Product("chair",40, 40);
//
//        List<Product> prList1 = new ArrayList<>();
//        prList1.add(pr1);
//        prList1.add(pr2);
//        prList1.add(pr3);
//
//        List<Product> prList2 = new ArrayList<>();
//        prList1.add(pr4);
//        prList1.add(pr5);
//
//        Client client1 = new Client("Mike", "Moscow", "mike", "123");
//        client1.createOrder(1, "London", prList1);
//        Client client2 = new Client("Jeff", "Milan", "jeff", "pass1");
//        client2.createOrder(1, "Paris", prList2);
//        try{
//            List<Client> clientList = new ArrayList<>();
//            clientList.add(client1);
//            clientList.add(client2);
//            SaveDB.saveClientList(clientList);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try{
            List<Client> clientList = LoadDB.loadClientList();
            List<Client> list = new ArrayList<>(clientList);
            list.add(new Client("Chrlie", "New York", "ch1", "password123"));
            SaveDB.saveClientList(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import domain.Client;
import domain.Order;
import domain.Product;
import domain.Status;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
//            clientList.add(client2);
//            clientList.add(client1);
//            SaveDB.saveClientList(clientList);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try{
            List<Client> clientList = LoadDB.loadClientList();
            List<Client> list = new ArrayList<>(clientList);
//            list.add(new Client("Charlie", "New York", "ch1", "password123"));


            for (int i = 0; i<100; i++){
                list.add(createClient());
            }
            Client client = ClientService.searchClient(clientList,"mike");
            System.out.println(list);
            SaveDB.saveClientList(list);

//            System.out.println(clientList);
//            System.out.println("============================");
//            ClientService.sortClientList(clientList);
//            System.out.println(clientList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Client createClient(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String login = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return new Client(login, "city", login, "pass");
    }
}

import domain.Client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClientService {

    public static Client searchClient(List<Client> list, String name){
        for(Client client:list){
            if (client.getLogin().equals(name))
                return client;
        }
        return null;
    }

    public static void sortClientList(List<Client> list){
        //List<Client> list1 = new ArrayList<>(list);
        Collections.sort(list);
    }
}

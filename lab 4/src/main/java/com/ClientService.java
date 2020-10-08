package com;

import com.domain.Client;

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
        Collections.sort(list);
    }
}

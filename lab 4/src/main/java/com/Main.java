package com;

import com.domain.Client;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try{
            Class.forName("org.postgresql.Driver");
            String dbURL = "jdbc:postgresql://localhost:5432/oodb";

            Connection connection = DriverManager.getConnection(dbURL, "postgres", "jessica17");
            //List<Client> clients = LoadFromDB.loadClientList(connection);

            List<Client> clients = LoadFromFile.loadClientList();

            ClientService.sortClientList(clients);
            assert clients != null;
            Client client = ClientService.searchClient(clients, "jeff");
            assert client != null;
            client.setName("Jeff1");

            SaveDB.saveClientList(clients, connection);

        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}

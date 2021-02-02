package com;

import com.domain.Client;
import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class SaveDB {
    public static void saveClientList(List<Client> clients, Connection connection) throws SQLException {
        if (clients != null && !clients.isEmpty()){
            Gson gson = new Gson();
            List<String> listJSONString = new ArrayList<>();
            for(Client client: clients){
                listJSONString.add(gson.toJson(client));
            }

//            PreparedStatement statement = connection.prepareStatement("INSERT INTO lab4 (json, jsonb) VALUES (cast(? as json), cast(? as jsonb))");
//            statement.setString(1, clientsAsJSON);
//            statement.setString(2, clientsAsJSON);

            //PreparedStatement statement = connection.prepareStatement("UPDATE lab4 SET json= cast(? as json) WHERE id=cast(? as INTEGER)");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO lab4 ( json) VALUES (cast(? as json))");

            int i = 1;
            Instant start = Instant.now();
            for (String str: listJSONString){
                statement.setString(1, str);
                statement.executeUpdate();
                i++;
            }
            //statement.executeUpdate();

            Instant end = Instant.now();
            System.out.println("JSON INSERT query time: "+ Duration.between(start, end));
            statement.close();

            PreparedStatement statement1 = connection.prepareStatement(" INSERT INTO lab4 ( jsonb) VALUES (cast(? as jsonb))");

            i = 1;
            start = Instant.now();
            for (String str: listJSONString){
                statement1.setString(1, str);
                statement1.executeUpdate();
                i++;
            }

            end = Instant.now();
            System.out.println("JSONB UPDATE query time: "+ Duration.between(start, end));
            statement1.close();
//            int count = statement.executeUpdate();
//            System.out.println(count+" records added");


        }
    }
}

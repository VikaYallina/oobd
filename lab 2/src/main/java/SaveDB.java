import com.google.gson.Gson;
import domain.Client;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class SaveDB {
    public static void saveClientList(List<Client> clientList) throws FileNotFoundException {
        if (!clientList.isEmpty()){
            Gson gson = new Gson();
            String clientListAsJSON = gson.toJson(clientList);
            System.out.println(clientListAsJSON);

            try(OutputStream outputStream = new FileOutputStream(new File("clients.json"))){
                outputStream.write(clientListAsJSON.getBytes(StandardCharsets.UTF_8));
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

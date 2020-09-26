import domain.Client;
import domain.Shop;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Collections;
import java.util.List;

public class ShopServiceXML {
    public static void saveDBtoXML(Shop shop){
        try{
            JAXBContext context = JAXBContext.newInstance(Shop.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(shop, new File("shop.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static Shop loadDBfromXML() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Shop.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (Shop) unmarshaller.unmarshal(new File("shop.xml"));
    }


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

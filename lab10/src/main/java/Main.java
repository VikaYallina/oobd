import domain.Client;
import domain.Shop;

import javax.persistence.*;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.SystemException;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws HeuristicRollbackException, RollbackException, HeuristicMixedException, SystemException {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("lab10");

        EntityManager entityManager = emf.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Client c = new Client();
        c.setName("Joe");
        c.setAddress("Moscow");
        c.setLogin("log");
        c.setPassword("pass");

        entityManager.persist(c);

        Shop shop = new Shop();
        shop.setId(1L);
        List<Client> list = new ArrayList<>();
        list.add(c);
        shop.setClientList(list);

        entityManager.persist(shop);

        transaction.commit();

        entityManager.close();
        emf.close();
    }

}

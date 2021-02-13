package com.example.demo.repository;

import com.example.demo.domain.Shop;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class ShopRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Shop> findAll(){
        return entityManager.createQuery("select s from Shop s").getResultList();
    }
}

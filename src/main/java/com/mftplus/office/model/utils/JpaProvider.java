package com.mftplus.office.model.utils;

import jakarta.persistence.Entity;
import lombok.Getter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaProvider {
    @Getter
    private static JpaProvider jpa = new JpaProvider();

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("office");

    private JpaProvider() {
    }

    public EntityManager getEntityManager() {return factory.createEntityManager();}
}

package com.infotera.teste.util;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.infotera.teste.model.Person;

import java.time.LocalDate;
import java.util.UUID;

@Startup
@Singleton
public class InitialDatabaseSeed {

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    public void init() {

        System.out.println("Initial database load");

        this.entityManager.persist(createPerson("Teste 1", "M", "teste1@gmail.com", "5511922222222"));
        this.entityManager.persist(createPerson("Teste 2", "F", "teste2@gmail.com", "5511922222222"));
        this.entityManager.persist(createPerson("Teste 3", "M", "teste3@gmail.com", "5511922222222"));
        this.entityManager.persist(createPerson("Teste 4", "F", "teste4@gmail.com", "5511911111111"));
        this.entityManager.persist(createPerson("Teste 5", "F", "teste5@gmail.com", "5511922222222"));
        this.entityManager.persist(createPerson("Teste 6", "M", "teste6@gmail.com", "5511933333333"));
        
    }

    private Person createPerson(
    		String name, 
    		String type, 
    		String email, 
    		String telephone
    ) {
        Person result = new Person();
        result.setName(name);
        result.setType(type);
        result.setEmail(email);
        result.setTelephone(telephone);
        return result;
    }
}

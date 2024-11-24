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

        System.out.println("Storing three initial persons");

        this.entityManager.persist(createPerson("John Doe", "M", "doe@john.de", "5511911111111"));
        this.entityManager.persist(createPerson("Max Mustermann", "M", "max@gmail.com", "5511922222222"));
        this.entityManager.persist(createPerson("Philip Riecks", "M", "philip@riecks.de", "5511933333333"));
        
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

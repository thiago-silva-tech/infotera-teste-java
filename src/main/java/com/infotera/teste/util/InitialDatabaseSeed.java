package com.infotera.teste.util;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.infotera.teste.model.Address;
import com.infotera.teste.model.Contact;
import com.infotera.teste.model.Document;
import com.infotera.teste.model.Person;

import java.util.Date;

@Startup
@Singleton
public class InitialDatabaseSeed {

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    public void init() {

        System.out.println("Initial database load");

        this.entityManager.persist(createRamdomPerson());
        this.entityManager.persist(createRamdomPerson());
        this.entityManager.persist(createRamdomPerson());
        this.entityManager.persist(createRamdomPerson());

    }

    private Person createRamdomPerson() {
    	int randomNumber = (int) (Math.random() * 1000) + 1;
    	
        Person person = new Person();
        person.setName("Teste " + randomNumber);
        person.setType("M");
        person.setEmail("teste"+randomNumber+"@gmail.com");
        person.setTelephone("5511922222222");
        
        Document document1 = new Document();
        document1.setDocumentNumber("12345678909");
        document1.setType("CPF");
        person.addDocument(document1);
        Document document2 = new Document();
        document2.setDocumentNumber("628378467");
        document2.setType("RG");
        Date newDate = new Date();
        newDate.setTime(newDate.getTime() + 1000);
        document2.setCreationDate(newDate);
        person.addDocument(document2);
        
        Contact contact1 = new Contact();
        contact1.setName("main contact");
        contact1.setEmail("teste"+randomNumber+"@gmail.com");
        contact1.setTelephoneNumber("5511922222222");
        person.addContact(contact1);

        Address address1 = new Address();
        address1.setAddressName("R. Teste de Oliveira");
        address1.setAddressNumber("12345");
        address1.setCityName("São Paulo");
        address1.setStateName("SP");
        address1.setCountryName("Brasil");
        person.addAddress(address1);

        return person;
    }
}

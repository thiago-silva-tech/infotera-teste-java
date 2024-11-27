package com.infotera.teste.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.infotera.teste.model.Person;
import java.util.List;

@Stateless
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> loadAllPersons() {
        return this.entityManager.createQuery("SELECT p FROM Person p", Person.class)
        		.setHint("javax.persistence.cache.storeMode", "REFRESH")
        		.getResultList();
    }

    public void addNewPerson(Person person) {
        this.entityManager.persist(person);
	}

    public void updatePerson(Person Person) {
    	entityManager.merge(Person);
    }
    
    public Person getFullPersonRecord(Person person) {
    	String jpql = "FROM Person p " +
    			"LEFT JOIN FETCH p.documents d " +
                "LEFT JOIN FETCH p.addresses a " +
                "LEFT JOIN FETCH p.contacts c " +
    			"WHERE p.id = :personId";
    	
    	TypedQuery<Person> query = entityManager.createQuery(jpql, Person.class);
    	query.setParameter("personId", person.getId());
    	Person fullPersonRecord = query.getSingleResult();
    	return fullPersonRecord;
    }
    
	public List<Person> searchByName(String name) {
		String jpql = "FROM Person WHERE name LIKE :name";
		
		TypedQuery<Person> query = entityManager
				.createQuery(jpql, Person.class);
		
		query.setParameter("name", "%" + name + "%");
		
		return query.getResultList();
	}
	
    public void delete(Person person) {
    	if(person != null) {
            if (entityManager.contains(person)) {
                entityManager.remove(person);
            } else {
                Person managedPerson = entityManager.find(Person.class, person.getId());
                if (managedPerson != null) {
                    entityManager.remove(managedPerson);
                }
            }
    	}
    }
}
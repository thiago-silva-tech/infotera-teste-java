package com.infotera.teste.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.infotera.teste.model.Address;
import com.infotera.teste.model.Contact;
import com.infotera.teste.model.Document;
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

    public void addNewPerson(Person person) {
        this.entityManager.persist(person);
	}

    public void update(List<Person> persons) {
    	persons.forEach(entityManager::merge);
    }
    
	public List<Person> searchByName(String name) {
		String jpql = "from Person where name like :name";
		
		TypedQuery<Person> query = entityManager
				.createQuery(jpql, Person.class);
		
		query.setParameter("name", "%" + name + "%");
		
		return query.getResultList();
	}
}
package com.infotera.teste.controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.infotera.teste.model.Person;
import com.infotera.teste.model.Address;
import com.infotera.teste.model.Contact;
import com.infotera.teste.model.Document;
import com.infotera.teste.repository.PersonRepository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class PersonController implements Serializable {

	private List<Person> persons;

	private Person person;

	private List<Contact> contacts;
	private List<Address> addresses;
	private List<Document> documents;

	private String searchInput;

	@Inject
	private PersonRepository personRepository;

	@PostConstruct
	public void init() {
		this.persons = personRepository.loadAllPersons();
	}

	public void delete(Person person) {
		personRepository.delete(person);
		persons.remove(person);
	}

	public void add() {
		personRepository.addNewPerson(
			person, 
			contacts, 
			documents, 
			addresses
		);
		loadRecords();
	}

	private void loadRecords() {
		if (searchInputIsFilled()) {
			search();
		} else {
			this.persons = personRepository.loadAllPersons();
		}
	}

	private boolean searchInputIsFilled() {
		return searchInput != null && !"".equals(searchInput);
	}

	public void search() {
		persons = personRepository.searchByName(searchInput);
	}

	public void update() {
		personRepository.update(persons);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Update successful"));
	}

	public void prepareNewPerson() {
		person = new Person();
		contacts = new ArrayList<Contact>();
		addresses = new ArrayList<Address>();
		documents = new ArrayList<Document>();
		//person.setContacts(contacts);
		//person.setAddresses(addresses);
		//person.setDocuments(documents);
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPerson(List<Person> persons) {
		this.persons = persons;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public PersonRepository getPersonRepository() {
		return personRepository;
	}

	public void setPersonRepository(PersonRepository personManager) {
		this.personRepository = personManager;
	}

	public String getSearchInput() {
		return searchInput;
	}

	public void setSearchInput(String searchInput) {
		this.searchInput = searchInput;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public void addContact(Contact contact) {
		this.contacts.add(contact);
	}
	
	public void addNewContact() {
		this.contacts.add(new Contact());
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> address) {
		this.addresses = address;
	}

	public void addAddress(Address address) {
		this.addresses.add(address);
	}

	public void addNewAddress() {
		this.addresses.add(new Address());
	}
	
	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public void addDocument(Document document) {
		this.documents.add(document);
	}
	
	public void addNewDocument() {
		this.documents.add(new Document());
	}
}

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
		personRepository.addNewPerson(person);
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
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public String getSearchInput() {
		return searchInput;
	}

	public void setSearchInput(String searchInput) {
		this.searchInput = searchInput;
	}

	public void addNewContact() {
		if (this.person != null) {
			this.person.addContact(new Contact());
		}
	}
	public void addNewAddress() {
		if (this.person != null) {
			this.person.addAddress(new Address());
		}
	}

	public void addNewDocument() {
		if (this.person != null) {
			this.person.addDocument(new Document());
		}
	}
}

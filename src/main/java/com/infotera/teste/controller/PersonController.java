package com.infotera.teste.controller;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.infotera.teste.repository.PersonRepository;
import com.infotera.teste.model.*;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class PersonController implements Serializable {

	private List<Person> persons;

	private Person person;

	private String searchInput;

	private String formModalTitle;
	
	private FormMode currentFormMode;
	
	public enum FormMode {
		CREATE, 
		UPDATE
	}
	
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

	public void save() {
		if(FormMode.CREATE.equals(currentFormMode)) {
			personRepository.addNewPerson(person);
		} else {
			personRepository.updatePerson(person);
		}
		
		loadRecords();
	}
	
	private void loadRecords() {
		if (searchInputIsFilled()) {
			this.persons = personRepository.searchByName(searchInput);
		} else {
			this.persons = personRepository.loadAllPersons();
		}
	}

	public void search() {
		persons = personRepository.searchByName(searchInput);
	}
	
	private boolean searchInputIsFilled() {
		return searchInput != null && !"".equals(searchInput);
	}

	public void prepareNewPerson() {
		currentFormMode = FormMode.CREATE;
		formModalTitle = "New Person";
		person = new Person();
	}
	
	public void prepareUpdatePerson(Person personToUpdate) {
		currentFormMode = FormMode.UPDATE;
		formModalTitle = "Edit Person";
		person = personRepository.getFullPersonRecord(personToUpdate);
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

	public String getFormModalTitle() {
		return formModalTitle;
	}

	public FormMode getCurrentFormMode() {
		return currentFormMode;
	}

	public void setCurrentFormMode(FormMode currentFormMode) {
		this.currentFormMode = currentFormMode;
	}

	public void setFormModalTitle(String formModalTitle) {
		this.formModalTitle = formModalTitle;
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

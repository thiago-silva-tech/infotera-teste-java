package com.infotera.teste.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Email;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nm_person", length = 200, nullable = false)
	@NotEmpty
	private String name;
	
	@Column(name = "tp_person", length = 2, nullable = false)
	@NotEmpty
	private String type;
	
	@Column(name = "nm_email", length = 200, nullable = false)
	@NotEmpty
	@Email
	private String email;
	
	@Column(name = "nr_telephone", length = 200, nullable = false)
	@NotEmpty
	private String telephone;

	@OneToMany(
			mappedBy = "person", 
			cascade = CascadeType.ALL, 
			orphanRemoval = true,
			fetch = FetchType.LAZY
	)
	 private List<Document> documents = new ArrayList<>();
	 
	@OneToMany(
			mappedBy = "person", 
			cascade = CascadeType.ALL, 
			orphanRemoval = true,
			fetch = FetchType.LAZY
	)
	private List<Address> addresses = new ArrayList<>();
	
	@OneToMany(
			mappedBy = "person", 
			cascade = CascadeType.ALL, 
			orphanRemoval = true,
			fetch = FetchType.LAZY
	)
	private List<Contact> contacts = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        documents.forEach(document -> document.setPerson(this));
        this.documents = documents;
    }
    
    public void addDocument(Document document) {
    	document.setPerson(this);
    	this.documents.add(document);
    }
    
    public void removeDocument(Document document) {
    	document.setPerson(null);
    	this.documents.add(document);
    }
	
	public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
    	addresses.forEach(address -> address.setPerson(this));
        this.addresses = addresses;
    }
    
    public void addAddress(Address address) {
    	address.setPerson(this);
    	this.addresses.add(address);
    }
    
    public void removeAddress(Address address) {
    	address.setPerson(null);
    	this.addresses.remove(address);
    }
    
	public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
    	contacts.forEach(contact -> contact.setPerson(this));
        this.contacts = contacts;
    }
    
    public void addContact(Contact contact) {
    	contact.setPerson(this);
    	this.contacts.add(contact);
    }
    
    public void removeContact(Contact contact) {
    	contact.setPerson(null);
    	this.contacts.remove(contact);
    }
}



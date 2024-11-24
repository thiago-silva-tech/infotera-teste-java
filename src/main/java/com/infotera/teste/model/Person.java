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
			orphanRemoval = true
	)
	 private List<Document> documents;
	 
	@OneToMany(
			mappedBy = "person", 
			cascade = CascadeType.ALL, 
			orphanRemoval = true
	)
	private List<Address> addresses;
	
	@OneToMany(
			mappedBy = "person", 
			cascade = CascadeType.ALL, 
			orphanRemoval = true
	)
	private List<Contact> contacts;
	
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
        this.documents = documents;
    }
    
    public void addDocument(Document document) {
    	this.documents.add(document);
    }
	
	public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
    
    public void addAddress(Address address) {
    	this.addresses.add(address);
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
}



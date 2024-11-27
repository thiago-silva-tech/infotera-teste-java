package com.infotera.teste.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "document")
public class Document {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;
	
	@Column(name = "nr_document", length = 45, nullable = false)
    @NotEmpty
	private String documentNumber;
	
	@Column(name = "tp_document", length = 45, nullable = false)
	@NotEmpty
	private String type;
	
	public Long getId() {
		return id;
	}

	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}

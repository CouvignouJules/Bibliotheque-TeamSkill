package fr.ynov.biblioskill.metier.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import fr.ynov.biblioskill.utilitaire.TypeAuteur;

@Entity
@Table(name ="auteur")
@NamedQuery(name="lireAuteurs",query="SELECT a FROM Auteur a")
@XmlRootElement
public class Auteur implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String aProposDe;
	private String nationalite;
	private TypeAuteur type;

	public Auteur() {
		// TODO Auto-generated constructor stub
	}

	public Auteur(Long id, String aProposDe, String nationalite, TypeAuteur type) {
		super();
		this.id = id;
		this.aProposDe = aProposDe;
		this.nationalite = nationalite;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getaProposDe() {
		return aProposDe;
	}

	public void setaProposDe(String aProposDe) {
		this.aProposDe = aProposDe;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public TypeAuteur getType() {
		return type;
	}

	public void setType(TypeAuteur type) {
		this.type = type;
	}

}

package fr.ynov.biblioskill.metier.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name ="pret")
@NamedQuery(name="lirePrets",query="SELECT p FROM Pret p")
public class Pret implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Temporal(TemporalType.DATE)
	private GregorianCalendar dateDebut;
	private int duree;

	public Pret() {
		// TODO Auto-generated constructor stub
	}

	public Pret(Long id, GregorianCalendar dateDebut, int duree) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.duree = duree;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public GregorianCalendar getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(GregorianCalendar dateDebut) {
		this.dateDebut = dateDebut;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

}

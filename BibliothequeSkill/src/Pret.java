import java.util.Date;

public class Pret {
	
	private Long id;
	private Date dateDebut;
	private int duree;

	public Pret() {
		// TODO Auto-generated constructor stub
	}

	public Pret(Long id, Date dateDebut, int duree) {
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

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

}

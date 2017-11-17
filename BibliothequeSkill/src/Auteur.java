
public class Auteur {
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

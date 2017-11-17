import java.util.Date;

public class Utilisateur {
	
	private Long id;
	private String nomUtilisateur;
	private String motDePasse;
	private AccountType statutCompte;
	private Date derniereConnexion;

	public Utilisateur() {
		// TODO Auto-generated constructor stub
	}

	public Utilisateur(Long id, String nomUtilisateur, String motDePasse, AccountType statutCompte,
			Date derniereConnexion) {
		super();
		this.id = id;
		this.nomUtilisateur = nomUtilisateur;
		this.motDePasse = motDePasse;
		this.statutCompte = statutCompte;
		this.derniereConnexion = derniereConnexion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public AccountType getStatutCompte() {
		return statutCompte;
	}

	public void setStatutCompte(AccountType statutCompte) {
		this.statutCompte = statutCompte;
	}

	public Date getDerniereConnexion() {
		return derniereConnexion;
	}

	public void setDerniereConnexion(Date derniereConnexion) {
		this.derniereConnexion = derniereConnexion;
	}

}

import java.util.Date;

public class Livre {
	
	private Long id;
	private String titre;
	private String resume;
	private int quantite;
	private String isbn;
	private String photo;
	private Date datePublication;

	public Livre() {
		// TODO Auto-generated constructor stub
	}

	public Livre(Long id, String titre, String resume, int quantite, String isbn, String photo, Date datePublication) {
		super();
		this.id = id;
		this.titre = titre;
		this.resume = resume;
		this.quantite = quantite;
		this.isbn = isbn;
		this.photo = photo;
		this.datePublication = datePublication;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}

}

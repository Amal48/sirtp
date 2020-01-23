package metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Article {
	@Id
	@GeneratedValue
	long id;
	
	public void setId(long id) {
		this.id = id;
	}
	String titre;
	Magazine magazine;
	
	
	public Article(String titre, Magazine magazine) {
		this.titre = titre;
		magazine = magazine;
	}
	
	@ManyToOne
	public Magazine getMagazine() {
		return magazine;
	}

	public void setmagazine(String magazine) {
		magazine = magazine;
	}

	@Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}


	
}

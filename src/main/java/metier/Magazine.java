package metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Magazine {
	
	long id;
	
	String name;
	
	List<Article> ListArticles = new ArrayList<Article>();
	
	public Magazine(String name, List<Article> listArticles) {
		this.name = name;
		ListArticles = listArticles;
	}
	
	@Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
	@OneToMany(mappedBy="magazine")
	public List<Article> getListArticles() {
		return ListArticles;
	}

	public void setListArticles(List<Article> listArticles) {
		ListArticles = listArticles;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	
}

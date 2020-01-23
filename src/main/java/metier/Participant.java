package metier;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Participant {

    @Id
    @GeneratedValue
    private long id;
    
    @ManyToMany 
    private Set<Sondage> SetSond = new HashSet<Sondage>();
    
    @ManyToMany
    private Set <Reunion> SetReu = new HashSet<Reunion>();

    @Transient
    private List<String> PrefAlimentaire= new ArrayList<String>();
    private String nom;
    private String prenom;
    private String mail;

    public Participant() {
		// TODO Auto-generated constructor stub
	}
    
    public Participant(List<String> prefAlimentaire, String nom, String prenom, String mail) {
        PrefAlimentaire = prefAlimentaire;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
    }

    public Participant(String nom, String prenom, String mail) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
    }


    public List<String> getPrefAlimentaire() {
        return PrefAlimentaire;
    }

    public void setPrefAlimentaire(List<String> prefAlimentaire) {
        PrefAlimentaire = prefAlimentaire;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        prenom = prenom;
    }

}

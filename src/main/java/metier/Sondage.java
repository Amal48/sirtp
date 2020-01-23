package metier;


import sun.awt.image.ImageWatched;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Sondage {

    @Id
    @GeneratedValue
    private long id;

    @ManyToMany
    private List<Participant> listeParticipant;

    @OneToMany
    private List<DateApp> listeChoixDateApp;

    @ManyToOne
    private UserApp userApp;
    
    

    private String lienSondage;
    
    

   

    public UserApp getUserApp() {
        return userApp;
    }

    public void setUserApp(UserApp userApp) {
        this.userApp = userApp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLienSondage() {
        return lienSondage;
    }

    public void setLienSondage(String lienSondage) {
        this.lienSondage = lienSondage;
    }

    public List<Participant> getListeParticipant() {
        return listeParticipant;
    }

    public void setListeParticipant(List<Participant> listeParticipant) {
        this.listeParticipant = listeParticipant;
    }

    public List<DateApp> getListeChoixDateApp() {
        return listeChoixDateApp;
    }

    public void setListeChoixDateApp(List<DateApp> listeChoixDateApp) {
        this.listeChoixDateApp = listeChoixDateApp;
    }

}

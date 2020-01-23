package metier;

import sun.awt.image.ImageWatched;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Reunion {

    @Id
    @GeneratedValue
    private long id;


    @ManyToMany
    private List<Participant> listeParticipant = new ArrayList<Participant>();
    
    @OneToOne
    private DateApp dateApp;

    private String clearode;
    private String pad;
    private String intitule;
    private String resume;

    public Reunion(DateApp dateApp, List<Participant> listeParticipant, String clearode, String pad, String intitule, String resume) {
        this.listeParticipant = listeParticipant;
        this.clearode = clearode;
        this.pad = pad;
        this.intitule = intitule;
        this.resume = resume;
    }

    public Reunion(DateApp dateApp, List<Participant> listeParticipant, String intitule) {
        this.dateApp = dateApp;
        this.listeParticipant = listeParticipant;
        this.intitule = intitule;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DateApp getDateApp() {
        return dateApp;
    }

    public void setDateApp(DateApp dateApp) {
        this.dateApp = dateApp;
    }

    public List<Participant> getListeParticipant() {
        return listeParticipant;
    }

    public void setListeParticipant(List<Participant> listeParticipant) {
        this.listeParticipant = listeParticipant;
    }

    public String getClearode() {
        return clearode;
    }

    public void setClearode(String clearode) {
        this.clearode = clearode;
    }

    public String getPad() {
        return pad;
    }

    public void setPad(String pad) {
        this.pad = pad;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

}
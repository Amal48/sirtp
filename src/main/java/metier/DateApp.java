package metier;

import javax.persistence.*;


import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class DateApp {

    @Id
    @GeneratedValue
    private long id;

    @Temporal(TemporalType.DATE)
    private Calendar date;
    
    @ManyToOne
    private Sondage sondage ;
    
    @OneToOne
    private Reunion reunion;
    
    private boolean pauseDej;

 

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Calendar getDateApp() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public boolean isPauseDej() {
        return pauseDej;
    }

    public void setPauseDej(boolean pauseDej) {
        this.pauseDej = pauseDej;
    }


}

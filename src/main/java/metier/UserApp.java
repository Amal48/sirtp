package metier;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class UserApp {
	@Id
    @GeneratedValue
    private long id;

    @OneToMany (mappedBy = "userApp", cascade = CascadeType.PERSIST )
    private Set<Sondage> SetSond = new HashSet<Sondage>();

    public UserApp(Set<Sondage> setSond) {
		super();
		SetSond = setSond;
	}

	public Set<Sondage> getSetSond() {
		return SetSond;
	}

	public void setSetSond(Set<Sondage> setSond) {
		SetSond = setSond;
	}



}

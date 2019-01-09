package ch.heigvd.gamification.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Badge implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Application application;

    private String idInGamifiedApplication;

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public Application getApplication() { return application; }

    public void setApplication(Application application) {
        this.application = application;
    }

    public String getIdInGamifiedApplication() { return idInGamifiedApplication; }

    public void setIdInGamifiedApplication(String idInGamifiedApplication) {
        this.idInGamifiedApplication = idInGamifiedApplication;
    }
}

package ch.heigvd.gamification.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Olivier Liechti
 */
@Entity
@Table(name="endUser")
public class EndUser implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  @ManyToOne
  private Application application;

  @OneToMany(mappedBy = "endUser", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<PointUser> pointsUser = new ArrayList<>();
  
  private String idInGamifiedApplication;
  
  private int numberOfEvents;

  public EndUser() {}

  public EndUser(String idInGamifiedApplication){
    this.idInGamifiedApplication = idInGamifiedApplication;
  }

  public List<PointUser> getPointsUser() {
    return pointsUser;
  }

  public void setPointsUser(List<PointUser> pointsUser) {
    this.pointsUser = pointsUser;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Application getApplication() {
    return application;
  }

  public void setApplication(Application application) {
    this.application = application;
  }

  public String getIdInGamifiedApplication() {
    return idInGamifiedApplication;
  }

  public void setIdInGamifiedApplication(String idInGamifiedApplication) {
    this.idInGamifiedApplication = idInGamifiedApplication;
  }

  public int getNumberOfEvents() {
    return numberOfEvents;
  }

  public void setNumberOfEvents(int numberOfEvents) {
    this.numberOfEvents = numberOfEvents;
  }

  @Override
  public boolean equals(Object obj){
    if(this == obj) return true;

    if(obj == null || getClass() != obj.getClass()) return false;

    EndUser endUser = (EndUser) obj;

    return Objects.equals(idInGamifiedApplication, endUser.idInGamifiedApplication);
  }

  @Override
  public int hashCode(){
    return Objects.hash(idInGamifiedApplication);
  }
}

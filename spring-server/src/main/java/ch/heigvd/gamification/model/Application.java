package ch.heigvd.gamification.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Olivier Liechti
 */
@Entity
public class Application implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(unique = true)
  private String name;

  @OneToMany
  private List<Badge> badges;

  @OneToMany
  private List<PointScale> pointScales;

  private String passwordHash;

  public long getId() {
    return id;
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

  public List<Badge> getBadges() { return badges; }

  public void setBadges(int index, Badge badge){
    badges.set(index, badge);
  }

  public String getPasswordHash() {
    return passwordHash;
  }

  public void setPasswordHash(String passwordHash) {
    this.passwordHash = passwordHash;
  }

}

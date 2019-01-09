package ch.heigvd.gamification.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="pointScale")
public class PointScale implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToOne
    private Badge badge;

    @OneToMany(mappedBy = "pointScale", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PointUser> pointUsers = new ArrayList<>();

    public PointScale() {}

    public PointScale(String name){
        this.name = name;
    }

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

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    public List<PointUser> getPointUsers() {
        return pointUsers;
    }

    public void setPointUsers(List<PointUser> pointUsers) {
        this.pointUsers = pointUsers;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;

        if(obj == null || getClass() != obj.getClass()) return false;

        PointScale pointScale = (PointScale) obj;

        return Objects.equals(name, pointScale.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }
}

package ch.heigvd.gamification.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class PointUser implements Serializable {

    @EmbeddedId
    private PointUserId id;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("endUserId")
    private EndUser endUser;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("pointScaleId")
    private PointScale pointScale;

    private int value;

    private PointUser() {}

    public PointUser(EndUser endUser, PointScale pointScale){
        this.endUser = endUser;
        this.pointScale = pointScale;
        this.id = new PointUserId(endUser.getId(), pointScale.getId());
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public PointUserId getId() {
        return id;
    }

    public void setId(PointUserId id) {
        this.id = id;
    }

    public EndUser getEndUser() {
        return endUser;
    }

    public void setEndUser(EndUser endUser) {
        this.endUser = endUser;
    }

    public PointScale getPointScale() {
        return pointScale;
    }

    public void setPointScale(PointScale pointScale) {
        this.pointScale = pointScale;
    }

    @Override
    public int hashCode() {
        return Objects.hash(endUser, pointScale);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;

        if(obj == null || getClass() != obj.getClass()) return false;

        PointUser that = (PointUser) obj;

        return Objects.equals(endUser, that.endUser) && Objects.equals(pointScale, that.pointScale);
    }
}

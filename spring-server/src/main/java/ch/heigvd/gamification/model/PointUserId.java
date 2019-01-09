package ch.heigvd.gamification.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PointUserId implements Serializable {

    @Column(name="endUser_id")
    private long endUserId;

    @Column(name="pointScale_id")
    private long pointScaleId;

    private PointUserId() {}

    public PointUserId(long endUserId, long pointScaleId){
        this.endUserId = endUserId;
        this.pointScaleId = pointScaleId;
    }

    public long getEndUserId() {
        return endUserId;
    }

    public void setEndUserId(long endUserId) {
        this.endUserId = endUserId;
    }

    public long getPointScaleId() {
        return pointScaleId;
    }

    public void setPointScaleId(long pointScaleId) {
        this.pointScaleId = pointScaleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(endUserId, pointScaleId);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;

        if(obj == null || getClass() != obj.getClass()) return false;

        PointUserId that = (PointUserId) obj;

        return Objects.equals(endUserId, that.endUserId) && Objects.equals(pointScaleId, that.pointScaleId);
    }
}

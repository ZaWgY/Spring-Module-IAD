package smth.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;


@Entity
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _id;

    public Point(Float x, Float y, Float r, Boolean hit, String userId) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.hit = hit;
        this.userId = userId;
    }

    public Point(){}

    public Point(Long _id,Float x, Float y, Float r, Boolean hit, String userId) {
        this._id = _id;
        this.x = x;
        this.y = y;
        this.r = r;
        this.hit = hit;
        this.userId = userId;
    }

    private Float x;
    private Float y;
    private Float r;
    private Boolean hit;
    private String userId;

    public Long getId() {
        return _id;
    }

    public void setId(Long _id) {
        this._id = _id;
    }

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public Float getR() {
        return r;
    }

    public void setR(Float r) {
        this.r = r;
    }

    public Boolean getHit() {
        return hit;
    }

    public void setHit(Boolean hit) {
        this.hit = hit;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean checkHit() {
        if (r > 0) {
            return ((x <= 0) && (y <= 0) && (x >= -r) && (y >= -(r / 2)))
                    || ((x <= 0) && (y >= 0)) && (2 * y - x <= r)
                    || ((x >= 0) && (y >= 0) && (r * r >= y * y + x * x));
        } else {
            float r_ = - r;
            return ((x >= 0) && (y >= 0) && (x <= r_) && (y <= (r_ / 2)))
                    || ((x >= 0) && (y <= 0)) && (2 * y - x >= - r_)
                    || ((x <= 0) && (y <= 0) && (r_ * r_ >= y * y + x * x));
        }
    }
}

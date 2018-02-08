package smth.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_;

    public Long getId_() {
        return id_;
    }

    public void setId_(Long id_) {
        this.id_ = id_;
    }

    public String getNameous() {
        return nameous;
    }

    public void setNameous(String nameous) {
        this.nameous = nameous;
    }

    public String getPasswordious() {
        return passwordious;
    }

    public void setPasswordious(String passwordious) {
        this.passwordious = passwordious;
    }

    public Person(){}

    @Override
    public String toString() {
        return this.getNameous() + ' ' + this.getPasswordious();
    }

    public Person(String nameous, String passwordious) {
        this.nameous = nameous;
        this.passwordious = passwordious;
    }

    private String nameous;
    private String passwordious;
}

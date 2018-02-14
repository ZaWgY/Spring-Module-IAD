package smth.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

    public String getHashMD5(String password){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());

            byte byteData[] = md.digest();

            StringBuilder sb = new StringBuilder();
            for (byte aByteData : byteData) {
                sb.append(Integer.toString((aByteData & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e ){
            System.out.println("No MD5");
        }
        return null;

    }


}

package capge_one_to_one.entity;

import jakarta.persistence.*;

@Entity
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int passportId;
    private String country;
    private String passportNumber;

    @OneToOne(mappedBy = "passport")
    private Human human;

    // -------- GETTERS --------

    public int getPassportId() {
        return passportId;
    }

    public String getCountry() {
        return country;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public Human getHuman() {
        return human;
    }

    // -------- SETTERS --------

    public void setPassportId(int passportId) {
        this.passportId = passportId;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    // -------- toString --------

    @Override
    public String toString() {
        return "Passport{" +
                "passportId=" + passportId +
                ", country='" + country + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                '}';
    }
}
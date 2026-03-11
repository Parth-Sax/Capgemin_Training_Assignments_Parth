package capge_one_to_one.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Pan {

    @Id
    private int panNumber;
    private String panAddress;

    @OneToOne
    private Person1 person1;

    // -------- GETTERS --------

    public int getPanNumber() {
        return panNumber;
    }

    public String getPanAddress() {
        return panAddress;
    }

    public Person1 getPerson1() {
        return person1;
    }

    // -------- SETTERS --------

    public void setPanNumber(int panNumber) {
        this.panNumber = panNumber;
    }

    public void setPanAddress(String panAddress) {
        this.panAddress = panAddress;
    }

    public void setPerson1(Person1 person1) {
        this.person1 = person1;
    }

    // -------- toString --------

    @Override
    public String toString() {
        return "Pan{" +
                "panNumber=" + panNumber +
                ", panAddress='" + panAddress + '\'' +
                '}';
    }
}
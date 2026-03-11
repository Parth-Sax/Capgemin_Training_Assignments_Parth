package capge_one_to_one.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Person1 {

    @Id
    private int id;
    private String name;

    @OneToOne
    private Pan pan;

    // -------- GETTERS --------

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Pan getPan() {
        return pan;
    }

    // -------- SETTERS --------

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPan(Pan pan) {
        this.pan = pan;
    }

    // -------- toString --------

    @Override
    public String toString() {
        return "Person1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pan=" + pan +
                '}';
    }
}
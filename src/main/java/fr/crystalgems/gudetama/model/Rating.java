package fr.crystalgems.gudetama.model;

import javax.persistence.*;

/**
 * Handle the definition of a rating in or model
 */
@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    @Column(nullable = false)
    private int value;
    @OneToOne
    private Subtitle subtitle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Subtitle getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(Subtitle subtilte) {
        this.subtitle = subtilte;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", value=" + value +
                ", subtitle=" + subtitle +
                '}';
    }
}

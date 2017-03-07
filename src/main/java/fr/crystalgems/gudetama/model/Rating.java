package fr.crystalgems.gudetama.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Handle the definition of a rating in or model
 */
@Entity
public class Rating {
    @Id
    private int id;
    @Basic
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
}

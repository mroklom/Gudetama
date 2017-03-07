package fr.crystalgems.gudetama.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * handle the definition of category in our model
 */
@Entity
public class Category {
    @Id
    private int id;
    @Basic
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String category) {
        this.name = category;
    }
}

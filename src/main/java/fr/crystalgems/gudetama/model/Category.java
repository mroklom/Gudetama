package fr.crystalgems.gudetama.model;

import javax.persistence.*;

/**
 * handle the definition of category in our model
 */
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    @Column(nullable = false)
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

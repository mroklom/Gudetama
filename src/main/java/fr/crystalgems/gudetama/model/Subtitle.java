package fr.crystalgems.gudetama.model;

import javax.persistence.*;
import java.util.HashSet;

/**
 * handle the definition of the subtitles in our model
 */
@Entity
public class Subtitle {
    @Id
    private int id;
    @Basic
    private String path;
    @ManyToOne
    private User publisher;
    @OneToMany
    private HashSet<Rating> ratings;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public User getPublisher() {
        return publisher;
    }

    public void setPublisher(User publisher) {
        this.publisher = publisher;
    }

    public HashSet<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(HashSet<Rating> ratings) {
        this.ratings = ratings;
    }
}

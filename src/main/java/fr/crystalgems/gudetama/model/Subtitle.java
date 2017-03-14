package fr.crystalgems.gudetama.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * handle the definition of the subtitles in our model
 */
@Entity
public class Subtitle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    @Column(nullable = false)
    private String path;
    @ManyToOne
    private User publisher;
    @OneToMany
    private Set<Rating> ratings;

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

    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subtitle subtitle = (Subtitle) o;
        return Objects.equals(path, subtitle.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path);
    }

    @Override
    public String toString() {
        return "Subtitle{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", publisher=" + publisher +
                ", ratings=" + ratings +
                '}';
    }
}

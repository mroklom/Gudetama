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
    @Column(nullable = false, unique = true)
    private String path;

    @OneToMany(fetch = FetchType.EAGER)
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

    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Subtitle subtitle = (Subtitle) o;
        return Objects.equals(path, subtitle.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path);
    }
}

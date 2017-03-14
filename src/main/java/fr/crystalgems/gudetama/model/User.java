package fr.crystalgems.gudetama.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * handle the definition of a user in our model
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    @Column(nullable = false)
    private String pseudo;
    @Basic
    @Column(nullable = false)
    private String email;
    @Basic
    @Column(nullable = false)
    private String password;
    @Basic
    @Column(nullable = false)
    private boolean admin;
    @OneToMany
    private Set<Video> bookmarks;
    @OneToMany
    private Set<Subtitle> subtitles;
    @OneToMany
    private Set<Rating> ratings;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Set<Video> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(HashSet<Video> bookmark) {
        this.bookmarks = bookmark;
    }

    public Set<Subtitle> getSubtitles() {
        return subtitles;
    }

    public void setSubtitles(HashSet<Subtitle> subtiltes) {
        this.subtitles = subtiltes;
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(HashSet<Rating> ratings) {
        this.ratings = ratings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(pseudo, user.pseudo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pseudo);
    }
}

package fr.crystalgems.gudetama.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;

/**
 * handle the definition of a user in our model
 */
@Entity
public class User {
    @Id
    private int id;
    @Basic
    private String pseudo;
    @Basic
    private String email;
    @Basic
    private String password;
    @Basic
    private boolean admin;
    @OneToMany
    private HashSet<Video> bookmarks;
    @OneToMany
    private HashSet<Subtitle> subtitles;
    @OneToMany
    private HashSet<Rating> ratings;

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

    public HashSet<Video> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(HashSet<Video> bookmark) {
        this.bookmarks = bookmark;
    }

    public HashSet<Subtitle> getSubtitles() {
        return subtitles;
    }

    public void setSubtitles(HashSet<Subtitle> subtiltes) {
        this.subtitles = subtiltes;
    }

    public HashSet<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(HashSet<Rating> ratings) {
        this.ratings = ratings;
    }
}

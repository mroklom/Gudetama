package fr.crystalgems.gudetama.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Handle the definition of a video on our model
 */
@Entity
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    @Column(nullable = false)
    private String path;
    @Basic
    @Column(nullable = false)
    private String title;
    @Basic
    @Column(nullable = false)
    private Date releaseDate;
    @Basic
    @Column(nullable = false)
    private int length;
    @ManyToOne
    private Category category;
    @OneToMany
    private Set<Subtitle> subtitles;

    public Video() {
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int lenght) {
        this.length = lenght;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Subtitle> getSubtitles() {
        return subtitles;
    }

    public void setSubtitles(HashSet<Subtitle> subtitles) {
        this.subtitles = subtitles;
    }
}

package fr.crystalgems.gudetama.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * Handle the definition of a video on our model
 */
@Entity
public class Video {
    @Id
    private int id;
    @Basic
    private String path;
    @Basic
    private String title;
    @Basic
    private Date releaseDate;
    @Basic
    private int length;
    @ManyToOne
    private Category category;
    @OneToMany
    private ArrayList<Subtitle> subtitles;

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

    public ArrayList<Subtitle> getSubtitles() {
        return subtitles;
    }

    public void setSubtitles(ArrayList<Subtitle> subtitles) {
        this.subtitles = subtitles;
    }
}

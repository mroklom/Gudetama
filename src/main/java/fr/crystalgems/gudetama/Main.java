package fr.crystalgems.gudetama;

import fr.crystalgems.gudetama.hibernate.HibernateUtil;
import fr.crystalgems.gudetama.model.Category;
import fr.crystalgems.gudetama.model.User;
import fr.crystalgems.gudetama.model.Video;
import org.hibernate.HibernateException;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by valen on 07/03/2017.
 */
public class Main {
    public static void main(final String[] args) throws Exception {
        Category noelCategory = new Category();
        noelCategory.setName("Noël 2016");

        Category automneCategorie = new Category();
        automneCategorie.setName("Automne 2016");

        Category printempsCategorie = new Category();
        printempsCategorie.setName("Printemps 2017");

        Video video1 = new Video();
        video1.setTitle("Episode 1");
        video1.setCategory(noelCategory);
        video1.setLength(144);
        video1.setPath("res\\gudetama e01.mp4");
        video1.setReleaseDate(new Date(System.currentTimeMillis()));

        Video video2 = new Video();
        video2.setTitle("Episode 2");
        video2.setCategory(noelCategory);
        video2.setLength(66);
        video2.setPath("res\\gudetama e02.mp4");
        video2.setReleaseDate(new Date(System.currentTimeMillis()));

        Video video3 = new Video();
        video3.setTitle("Episode 3");
        video3.setCategory(noelCategory);
        video3.setLength(66);
        video3.setPath("res\\gudetama e03.mp4");
        video3.setReleaseDate(new Date(System.currentTimeMillis()));

        Video video4 = new Video();
        video4.setTitle("Episode 4");
        video4.setCategory(noelCategory);
        video4.setLength(66);
        video4.setPath("res\\gudetama e04.mp4");
        video4.setReleaseDate(new Date(System.currentTimeMillis()));

        User user1 = new User();
        user1.setPseudo("nom");
        user1.setEmail("nom@qcq");
        user1.setPassword("1230");
        user1.setAdmin(false);
        user1.setBookmarks(new HashSet<>(Arrays.asList(video1, video2)));

        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

            HibernateUtil.getSessionFactory().getCurrentSession().save(noelCategory);
            HibernateUtil.getSessionFactory().getCurrentSession().save(automneCategorie);
            HibernateUtil.getSessionFactory().getCurrentSession().save(printempsCategorie);
            HibernateUtil.getSessionFactory().getCurrentSession().save(video1);
            HibernateUtil.getSessionFactory().getCurrentSession().save(video2);
            HibernateUtil.getSessionFactory().getCurrentSession().save(user1);
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
            System.out.println("Data inserted!");
        } catch (HibernateException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
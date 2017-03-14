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
        video1.setCategory(noelCategory);
        video1.setLength(144);
        video1.setPath("//etc//coucou");
        video1.setReleaseDate(new Date(System.currentTimeMillis()));

        Video video2 = new Video();
        video2.setCategory(noelCategory);
        video2.setLength(66);
        video2.setPath("//etc//coucou2");
        video2.setReleaseDate(new Date(System.currentTimeMillis()));

        User user1 = new User();
        user1.setPseudo("nom");
        user1.setEmail("nom@qcq");
        user1.setPassword("1230");
        user1.setAdmin(false);
        user1.setBookmarks(new HashSet<Video>(Arrays.asList(video1)));

        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

            HibernateUtil.getSessionFactory().getCurrentSession().save(noelCategory);
            HibernateUtil.getSessionFactory().getCurrentSession().save(automneCategorie);
            HibernateUtil.getSessionFactory().getCurrentSession().save(printempsCategorie);

            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
            System.out.println("Category saved!");
        } catch (HibernateException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
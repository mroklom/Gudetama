package fr.crystalgems.gudetama;

import fr.crystalgems.gudetama.hibernate.HibernateUtil;
import fr.crystalgems.gudetama.model.*;
import org.hibernate.HibernateException;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;

/**
 * Created by valen on 07/03/2017.
 */
public class Main {

    private Main() {
    }

    public static void main(final String[] args) throws Exception {
        Calendar calendar = Calendar.getInstance();

        Category piCategory = new Category();
        piCategory.setName("A π birth day");

        Category marsCategory = new Category();
        marsCategory.setName("Mars 2017");

        Category projectCategory = new Category();
        projectCategory.setName("Project Time");

        Video video1 = new Video();
        video1.setTitle("ぐでたまショートアニメ 第735話「スライサー」（3/13放送）");
        video1.setLength(61);
        video1.setPath("res/video/e735.mp4");
        calendar.set(2017, Calendar.MARCH, 12);
        video1.setReleaseDate(calendar.getTime());
        video1.setCategory(marsCategory);

        Video video2 = new Video();
        video2.setTitle("ぐでたまショートアニメ 第736話「ホワイトデーのお返し」（3/14放送） ");
        video2.setLength(61);
        video2.setPath("res/video/e736.mp4");
        calendar.set(2017, Calendar.MARCH, 13);
        video2.setReleaseDate(calendar.getTime());
        video2.setCategory(marsCategory);

        Video video3 = new Video();
        video3.setTitle("ぐでたまショートアニメ 第737話「押すなよ、押すなよ？」（3/15放送） ");
        video3.setLength(61);
        video3.setPath("res/video/e737.mp4");
        calendar.set(2017, Calendar.MARCH, 14);
        video3.setReleaseDate(calendar.getTime());
        video3.setCategory(piCategory);

        Video video4 = new Video();
        video4.setTitle("ぐでたまショートアニメ 第738話「浦島ニセ太郎」（3/16放送） ");
        video4.setLength(61);
        video4.setPath("res/video/e738.mp4");
        calendar.set(2017, Calendar.MARCH, 15);
        video4.setReleaseDate(calendar.getTime());
        video4.setCategory(projectCategory);

        Video video5 = new Video();
        video5.setTitle("ぐでたまショートアニメ 第739話「旅立ち」（3/17放送） ");
        video5.setLength(61);
        video5.setPath("res/video/e739.mp4");
        calendar.set(2017, Calendar.MARCH, 16);
        video5.setReleaseDate(calendar.getTime());
        video5.setCategory(projectCategory);

        User user1 = new User();
        user1.setPseudo("Antoine");
        user1.setEmail("antoine@email.com");
        user1.setPassword("antoine");
        user1.setAdmin(false);
        user1.setBookmarks(new HashSet<>(Arrays.asList(video1, video2)));

        User user2 = new User();
        user2.setPseudo("Alex");
        user2.setEmail("alex@email.com");
        user2.setPassword("alex");
        user2.setAdmin(false);
        user2.setBookmarks(new HashSet<>(Arrays.asList(video1, video3, video4)));

        User user3 = new User();
        user3.setPseudo("valentin");
        user3.setEmail("valentin@email.com");
        user3.setPassword("valentin");
        user3.setAdmin(false);
        user3.setBookmarks(new HashSet<>(Arrays.asList(video1, video2, video3, video5)));

        User user4 = new User();
        user4.setPseudo("Léo");
        user4.setEmail("leo@email.com");
        user4.setPassword("léo");
        user4.setAdmin(false);
        user4.setBookmarks(new HashSet<>(Arrays.asList(video4, video5)));

        Subtitle subtitle1 = new Subtitle();
        subtitle1.setPath("res/subtitle/slicer_sub.srt");

        Subtitle subtitle2 = new Subtitle();
        subtitle2.setPath("res/subtitle/revenir pour White Day_sub.srt");

        user1.setSubtitles(new HashSet<>(Arrays.asList(subtitle1, subtitle2)));

        Subtitle subtitle3 = new Subtitle();
        subtitle3.setPath("res/subtitle/Journey_sub.srt");

        user2.setSubtitles(new HashSet<>(Arrays.asList(subtitle3)));

        Subtitle subtitle4 = new Subtitle();
        subtitle4.setPath("res/subtitle/Je ne pas appuyer sur, vous n'appuyez sur_sub.srt");

        Subtitle subtitle5 = new Subtitle();
        subtitle5.setPath("res/subtitle/false Urashima Taro_sub.srt");

        user4.setSubtitles(new HashSet<>(Arrays.asList(subtitle4, subtitle5)));

        Subtitle subtitle6 = new Subtitle();
        subtitle6.setPath("res/subtitle/ep735.srt");

        Subtitle subtitle7 = new Subtitle();
        subtitle7.setPath("res/subtitle/ep736.srt");

        Subtitle subtitle8 = new Subtitle();
        subtitle8.setPath("res/subtitle/ep737.srt");

        Subtitle subtitle9 = new Subtitle();
        subtitle9.setPath("res/subtitle/ep738.srt");

        Subtitle subtitle10 = new Subtitle();
        subtitle10.setPath("res/subtitle/ep739.srt");

        user3.setSubtitles(new HashSet<>(Arrays.asList(subtitle6, subtitle7, subtitle8, subtitle9, subtitle10)));

        video1.setSubtitles(new HashSet<>(Arrays.asList(subtitle1, subtitle6)));
        video2.setSubtitles(new HashSet<>(Arrays.asList(subtitle2, subtitle7)));
        video3.setSubtitles(new HashSet<>(Arrays.asList(subtitle3, subtitle8)));
        video4.setSubtitles(new HashSet<>(Arrays.asList(subtitle4, subtitle9)));
        video5.setSubtitles(new HashSet<>(Arrays.asList(subtitle5, subtitle10)));

        Rating rating1 = new Rating();
        rating1.setValue(1);

        Rating rating2 = new Rating();
        rating2.setValue(1);

        Rating rating3 = new Rating();
        rating3.setValue(1);

        Rating rating4 = new Rating();
        rating4.setValue(1);

        Rating rating5 = new Rating();
        rating5.setValue(1);

        user2.setRatings(new HashSet<>(Arrays.asList(rating1, rating2, rating3, rating4, rating5)));

        Rating rating6 = new Rating();
        rating6.setValue(-1);

        Rating rating7 = new Rating();
        rating7.setValue(1);

        user1.setRatings(new HashSet<>(Arrays.asList(rating6, rating7)));

        Rating rating8 = new Rating();
        rating8.setValue(-1);

        user3.setRatings(new HashSet<>(Arrays.asList(rating8)));

        Rating rating9 = new Rating();
        rating9.setValue(1);

        Rating rating10 = new Rating();
        rating10.setValue(-1);

        Rating rating11 = new Rating();
        rating11.setValue(-1);

        user4.setRatings(new HashSet<>(Arrays.asList(rating9, rating10, rating11)));

        subtitle1.setRatings(new HashSet<>(Arrays.asList(rating7)));
        subtitle2.setRatings(new HashSet<>(Arrays.asList(rating8, rating9)));
        subtitle3.setRatings(new HashSet<>(Arrays.asList(rating10)));
        subtitle4.setRatings(null);
        subtitle5.setRatings(new HashSet<>(Arrays.asList(rating11)));
        subtitle6.setRatings(new HashSet<>(Arrays.asList(rating1)));
        subtitle7.setRatings(new HashSet<>(Arrays.asList(rating2)));
        subtitle8.setRatings(new HashSet<>(Arrays.asList(rating3)));
        subtitle9.setRatings(new HashSet<>(Arrays.asList(rating4, rating6)));
        subtitle10.setRatings(new HashSet<>(Arrays.asList(rating5)));

        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

            HibernateUtil.getSessionFactory().getCurrentSession().save(piCategory);
            HibernateUtil.getSessionFactory().getCurrentSession().save(projectCategory);
            HibernateUtil.getSessionFactory().getCurrentSession().save(marsCategory);


            HibernateUtil.getSessionFactory().getCurrentSession().save(video1);
            HibernateUtil.getSessionFactory().getCurrentSession().save(video2);
            HibernateUtil.getSessionFactory().getCurrentSession().save(video3);
            HibernateUtil.getSessionFactory().getCurrentSession().save(video4);
            HibernateUtil.getSessionFactory().getCurrentSession().save(video5);

            HibernateUtil.getSessionFactory().getCurrentSession().save(user1);
            HibernateUtil.getSessionFactory().getCurrentSession().save(user2);
            HibernateUtil.getSessionFactory().getCurrentSession().save(user3);
            HibernateUtil.getSessionFactory().getCurrentSession().save(user4);

            HibernateUtil.getSessionFactory().getCurrentSession().save(subtitle1);
            HibernateUtil.getSessionFactory().getCurrentSession().save(subtitle2);
            HibernateUtil.getSessionFactory().getCurrentSession().save(subtitle3);
            HibernateUtil.getSessionFactory().getCurrentSession().save(subtitle4);
            HibernateUtil.getSessionFactory().getCurrentSession().save(subtitle5);
            HibernateUtil.getSessionFactory().getCurrentSession().save(subtitle6);
            HibernateUtil.getSessionFactory().getCurrentSession().save(subtitle7);
            HibernateUtil.getSessionFactory().getCurrentSession().save(subtitle8);
            HibernateUtil.getSessionFactory().getCurrentSession().save(subtitle9);
            HibernateUtil.getSessionFactory().getCurrentSession().save(subtitle10);

            HibernateUtil.getSessionFactory().getCurrentSession().save(rating1);
            HibernateUtil.getSessionFactory().getCurrentSession().save(rating2);
            HibernateUtil.getSessionFactory().getCurrentSession().save(rating3);
            HibernateUtil.getSessionFactory().getCurrentSession().save(rating4);
            HibernateUtil.getSessionFactory().getCurrentSession().save(rating5);
            HibernateUtil.getSessionFactory().getCurrentSession().save(rating6);
            HibernateUtil.getSessionFactory().getCurrentSession().save(rating7);
            HibernateUtil.getSessionFactory().getCurrentSession().save(rating8);
            HibernateUtil.getSessionFactory().getCurrentSession().save(rating9);
            HibernateUtil.getSessionFactory().getCurrentSession().save(rating10);
            HibernateUtil.getSessionFactory().getCurrentSession().save(rating11);
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();

            System.out.println("Data inserted!");
        } catch (HibernateException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
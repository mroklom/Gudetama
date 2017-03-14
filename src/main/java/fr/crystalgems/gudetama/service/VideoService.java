package fr.crystalgems.gudetama.service;

import fr.crystalgems.gudetama.hibernate.HibernateUtil;
import fr.crystalgems.gudetama.model.Video;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Antoine on 14/03/2017.
 */
@Path("/video")
public class VideoService {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + "; charset-UTF-8")
    public Video getVideoByIdInJSON(@PathParam("id") int id) {
        Video video = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            video = session.load(Video.class, id);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null)
                tx.rollback();
            throw e;
        } finally {
            session.close();
        }
        return video;
    }
}

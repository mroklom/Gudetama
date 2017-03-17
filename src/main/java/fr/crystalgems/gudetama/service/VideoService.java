package fr.crystalgems.gudetama.service;

import fr.crystalgems.gudetama.hibernate.HibernateUtil;
import fr.crystalgems.gudetama.model.Video;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Antoine on 14/03/2017.
 */
@Path("video")
public class VideoService {

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Video getVideoByIdInJSON(@PathParam("id") int id) {
        Video video;
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            video = HibernateUtil.getSessionFactory().getCurrentSession().get(Video.class, id);
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }
        return video;
    }
}

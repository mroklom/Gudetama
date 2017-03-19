package fr.crystalgems.gudetama.service;

import fr.crystalgems.gudetama.hibernate.HibernateUtil;
import fr.crystalgems.gudetama.model.Video;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

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

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public List getVideoListINJSON() {
        List videos;
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            videos = HibernateUtil.getSessionFactory().getCurrentSession().createQuery("from Video v").list();
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }
        return videos;
    }

    @PUT
    @Path("delete")
    @Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Response deleteUser(Video videoToDelete) {
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            Video video = HibernateUtil.getSessionFactory().getCurrentSession().load(Video.class, videoToDelete.getId());
            HibernateUtil.getSessionFactory().getCurrentSession().delete(video);
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }
        return Response.status(200).build();
    }
}

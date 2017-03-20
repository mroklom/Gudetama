package fr.crystalgems.gudetama.service;

import fr.crystalgems.gudetama.hibernate.HibernateUtil;
import fr.crystalgems.gudetama.model.Subtitle;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Antoine on 18/03/2017.
 */
@Path("subtitle")
public class SubtitleServcie {
    @GET
    @Path("publisher/{id}")
    @Produces(MediaType.TEXT_PLAIN + "; charset=UTF-8")
    public String getPublisherNameByIdInJSON(@PathParam("id") int id) {
        String publisherName = "Utilsateur inconnu";
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            publisherName = (String) HibernateUtil.getSessionFactory().getCurrentSession().createQuery("select U.pseudo from User U join U.subtitles S where S.id = " + id).uniqueResult();
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }
        return publisherName;
    }

    @PUT
    @Path("delete")
    @Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Response deleteUser(@QueryParam("id") int id) {
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            Subtitle subtitle = HibernateUtil.getSessionFactory().getCurrentSession().load(Subtitle.class, id);
            HibernateUtil.getSessionFactory().getCurrentSession().delete(subtitle);
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }
        return Response.status(200).build();
    }
}

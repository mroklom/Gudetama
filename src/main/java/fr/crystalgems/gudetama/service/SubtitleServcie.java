package fr.crystalgems.gudetama.service;

import fr.crystalgems.gudetama.hibernate.HibernateUtil;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
}

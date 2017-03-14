package fr.crystalgems.gudetama.service;

import fr.crystalgems.gudetama.hibernate.HibernateUtil;
import fr.crystalgems.gudetama.model.User;
import org.hibernate.HibernateException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Antoine on 14/03/2017.
 */

@Path("/user")
public class UserService {

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserByIdInJSON(@PathParam("id") int id) {
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            User user = HibernateUtil.getSessionFactory().getCurrentSession().load(User.class, id);
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
            return user;
        } catch (HibernateException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
        }
        return null;
    }
}

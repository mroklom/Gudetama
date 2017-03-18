package fr.crystalgems.gudetama.service;

import fr.crystalgems.gudetama.hibernate.HibernateUtil;
import fr.crystalgems.gudetama.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Antoine on 14/03/2017.
 */

@Path("user")
public class UserService {

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public User getUserByIdInJSON(@PathParam("id") int id) {
        User user;
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            user = HibernateUtil.getSessionFactory().getCurrentSession().get(User.class, id);
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }
        return user;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Response createUserInJSON(User user) {
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            HibernateUtil.getSessionFactory().getCurrentSession().save(user);
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }
        return Response.status(201).build();
    }

    @Path("connexion")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public User connexion(@QueryParam("email") String email, @QueryParam("password") String password) {
        User user = null;
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            List users = HibernateUtil.getSessionFactory().getCurrentSession().createQuery("from User U where U.email = '" + email + "'").list();
            if (users.iterator().hasNext() && users.size() == 1)
                user = (User) users.iterator().next();
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }

        if (user != null) {
            if (user.getPassword().equals(password)) {
                user.setPassword(null);
                return user;
            }
        }
        return null;
    }

    @GET
    @Path("check-email")
    public Boolean checkEmail(@QueryParam("email") String email) {

        boolean response = false;

        System.out.println("Email : " + email);
        boolean response;

        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

            List result = HibernateUtil.getSessionFactory().getCurrentSession().createQuery("from User E where E.email = '" + email + "'").list();
            System.out.println(result.size());
            response = result.size() == 0;

            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }

        return new Boolean(response);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Response updateUser(User userForm) {
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            User user = HibernateUtil.getSessionFactory().getCurrentSession().load(User.class, userForm.getId());
            if (!"".equals(userForm.getEmail()))
                user.setEmail(userForm.getEmail());
            if (!"".equals(userForm.getPassword()))
                user.setPassword(userForm.getPassword());
            if (!"".equals(userForm.getPseudo()))
                user.setPseudo(userForm.getPseudo());
            HibernateUtil.getSessionFactory().getCurrentSession().update(user);
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }
        return Response.status(200).build();
    }

    @PUT
    @Path("delete")
    @Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Response deleteUser(User userForm) {
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            User user = HibernateUtil.getSessionFactory().getCurrentSession().load(User.class, userForm.getId());
            HibernateUtil.getSessionFactory().getCurrentSession().delete(user);
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }
        return Response.status(200).build();
    }


}
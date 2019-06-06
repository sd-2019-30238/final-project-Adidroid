package com.a2.springboot.web.Assignment2.Model.DAO.impl;



import com.a2.springboot.web.Assignment2.Model.Data.Reservation;
import com.a2.springboot.web.Assignment2.Model.Data.Table;
import com.a2.springboot.web.Assignment2.Model.Data.User;
import com.a2.springboot.web.Assignment2.Model.DAO.UserDAOInterface;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.util.List;

public class UserDAO extends AbstractDAO<User> implements UserDAOInterface {
    public UserDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
        setClazz(User.class);
    }

    @Override

    @Transactional()
    public User findByUsername(String username) {
        beginTransaction();
        User user= sessionFactory.getCurrentSession().get(User.class,username);
        //Hibernate.initialize(user.getBooksBucket());

        commitTransaction();
        return user;
    }

    @SuppressWarnings("unchecked")
    public List<Reservation> getUserReservations(User user){
        beginTransaction();

        Session session=sessionFactory.getCurrentSession();
        List<Reservation> userReservations= session.createQuery("from Reservation r where r.user=" + "\'" +user.getUsername() + "\'").list();
        commitTransaction();

        return userReservations;
    }

    public List<Reservation> getUsernameReservations(String username){
        User user=findByUsername(username);
        return getUserReservations(user);
    }
}

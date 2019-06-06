package com.a2.springboot.web.Assignment2.Model.DAO.impl;

import com.a2.springboot.web.Assignment2.Model.Data.Reservation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ReservationDAO extends AbstractDAO<Reservation> implements ReservationDAOInterface{


    public ReservationDAO(SessionFactory sessionFactory){
        super(sessionFactory);
        setClazz(Reservation.class);

    }

    public List<Reservation> getTableReservation (int tableId){
        beginTransaction();

        Session session=sessionFactory.getCurrentSession();
        List<Reservation> tableReservations= session.createQuery("from Reservation r where r.table=" + "\'" +tableId + "\'").list();
        commitTransaction();

        return tableReservations;

    }
}

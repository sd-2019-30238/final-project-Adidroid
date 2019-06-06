package com.a2.springboot.web.Assignment2.Model.Services.DBAccess;

import com.a2.springboot.web.Assignment2.Model.DAO.SessionUtil;
import com.a2.springboot.web.Assignment2.Model.DAO.impl.ReservationDAO;
import com.a2.springboot.web.Assignment2.Model.Data.Reservation;

import java.util.List;

public class ReservationService {

    public static void addReservation(Reservation reservation){
        new ReservationDAO(SessionUtil.getSessionFactory()).save(reservation);
    }

    public static Reservation get(int id){
       return  new ReservationDAO(SessionUtil.getSessionFactory()).get(id);

    }

    public static List<Reservation> getAll(){
        return  new ReservationDAO(SessionUtil.getSessionFactory()).getAll();
    }

    public static void deleteById(int id){
        new ReservationDAO(SessionUtil.getSessionFactory()).deleteById(id);

    }

    public static void update(Reservation reservation){
        new ReservationDAO(SessionUtil.getSessionFactory()).update(reservation);

    }

    public static List<Reservation> getTableReservations(int tableId){
        return  new ReservationDAO(SessionUtil.getSessionFactory()).getTableReservation(tableId);
    }
}

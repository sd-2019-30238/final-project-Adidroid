package com.a2.springboot.web.Assignment2.Model.Data;

import javax.persistence.*;

@Entity(name="TableR")
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private int seats;



   // @Column(name = "user_id", insertable = false, updatable = false)
   // private String user_id;

    //@ManyToOne
   // @JoinColumn(name="reservation_id")
   // private Reservation reservation;

   // @Column(name = "reservation_id", insertable = false, updatable = false)
   // private int reservation_id;




    public Table() {

    }

    public Table(int seats) {
        this.seats=seats;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }







}

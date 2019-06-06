package com.a2.springboot.web.Assignment2.Model.Data;



import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private int startHour;

    @Column
    private int endHour;

    @Column(nullable = false)
    private int status=0;


    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="table_id")
    private Table table;

  //  @Column(name = "user_id", insertable = false, updatable = false)
    //private String user_id;


    public Reservation(int startHour, int endHour, User user, Table table) {
        this.id = id;
        this.startHour = startHour;
        this.endHour = endHour;
        this.user = user;
        this.table=table;
    }

    public Reservation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user.getUsername();
    }

    public void setUser(User user) {
        this.user = user;
    }



    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public int getTable() {
        return table.getId();
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

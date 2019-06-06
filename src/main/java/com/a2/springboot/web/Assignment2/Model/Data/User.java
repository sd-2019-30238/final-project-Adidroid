package com.a2.springboot.web.Assignment2.Model.Data;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.awt.print.Book;
import java.util.Set;

@Entity
public class User extends Account  {

    @Column
    @ColumnDefault("0")
    private int money;

    public User(String username, String password) {
        super(username, password);


    }

    public User(){

    }



    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }


}

package com.a2.springboot.web.Assignment2.Model.Services.DBAccess;



import com.a2.springboot.web.Assignment2.Model.DAO.SessionUtil;
import com.a2.springboot.web.Assignment2.Model.DAO.impl.TableDAO;
import com.a2.springboot.web.Assignment2.Model.Data.Table;


import java.awt.print.Book;
import java.util.List;

public class TableService {


    public static void addTable(Table table){
        new TableDAO(SessionUtil.getSessionFactory()).save(table);

    }

    public static Table get(int id){
        return new TableDAO(SessionUtil.getSessionFactory()).get(id);
    }

    public static List<Table> getAll(){
        return new TableDAO(SessionUtil.getSessionFactory()).getAll();
    }

    public static void deleteById(int id){
        new TableDAO(SessionUtil.getSessionFactory()).deleteById(id);
    }

    public static void update(Table table){
        new TableDAO(SessionUtil.getSessionFactory()).update(table);
    }






}

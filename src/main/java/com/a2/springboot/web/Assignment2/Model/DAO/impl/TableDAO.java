package com.a2.springboot.web.Assignment2.Model.DAO.impl;



import com.a2.springboot.web.Assignment2.Model.DAO.TableDAOInterface;
import com.a2.springboot.web.Assignment2.Model.Data.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class TableDAO extends AbstractDAO<Table> implements TableDAOInterface {

    public TableDAO(SessionFactory sessionFactory){
        super(sessionFactory);
        setClazz(Table.class);

    }



}

package com.a2.springboot.web.Assignment2.Model.DAO.impl;

import com.a2.springboot.web.Assignment2.Model.Data.Staff;
import com.a2.springboot.web.Assignment2.Model.DAO.StaffDAOInterface;
import org.hibernate.SessionFactory;

public class StaffDAO extends AbstractDAO<Staff> implements StaffDAOInterface {
    public StaffDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
        setClazz(Staff.class);
    }

    @Override
    public Staff findByUsername(String username) {
        beginTransaction();
        Staff staff=sessionFactory.getCurrentSession().get(Staff.class, username);
        commitTransaction();
        return staff;

    }
}

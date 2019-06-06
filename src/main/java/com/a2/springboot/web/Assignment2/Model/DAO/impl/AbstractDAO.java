package com.a2.springboot.web.Assignment2.Model.DAO.impl;


import com.a2.springboot.web.Assignment2.Model.DAO.CRUD;
import org.hibernate.SessionFactory;

import java.util.List;


public class AbstractDAO<T> implements CRUD<T> {

    protected SessionFactory sessionFactory = null;
    private Class<T> clazz;


    public AbstractDAO() {

    }

    public AbstractDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    public void setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }


    @Override

    public T get(int id) {
        beginTransaction();
        T entity= sessionFactory.getCurrentSession().get(clazz, id);
        commitTransaction();
        return entity;

    }

    @Override

    @SuppressWarnings("unchecked")
    public List<T> getAll() {

        beginTransaction();
        List list= sessionFactory.getCurrentSession().createQuery("from " + clazz.getName()).getResultList();
        commitTransaction();
        return list;

    }

    @Override

    public void save(T entity) {
        beginTransaction();
        sessionFactory.getCurrentSession().save(entity);
        commitTransaction();

    }

    @Override

    public void update(T entity) {
        beginTransaction();
        sessionFactory.getCurrentSession().merge(entity);
        commitTransaction();

    }

    @Override

    public void delete(T entity) {
        beginTransaction();
        sessionFactory.getCurrentSession().delete(entity);
        commitTransaction();

    }

    public void deleteById( int entityId ) {
        T entity = get( entityId );
        delete( entity );
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    protected void beginTransaction(){
        sessionFactory.getCurrentSession().beginTransaction();
    }

    protected void commitTransaction(){
        sessionFactory.getCurrentSession().getTransaction().commit();
    }


}

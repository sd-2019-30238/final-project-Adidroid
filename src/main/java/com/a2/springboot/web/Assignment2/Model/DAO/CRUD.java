package com.a2.springboot.web.Assignment2.Model.DAO;

import java.util.List;

public interface CRUD<T> {

    T get(int id);

    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete(T t);

     void deleteById(int entityId);

}



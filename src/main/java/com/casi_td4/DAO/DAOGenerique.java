package com.casi_td4.DAO;

import java.sql.ResultSet;
import java.util.LinkedList;

import com.casi_td4.MySQLManager;
import com.casi_td4.modele.BasicEntity;

public abstract class DAOGenerique<T extends BasicEntity> {

    public DAOGenerique() {
    }

    public abstract boolean delete(T obj);

    public abstract T create(T obj);

    public abstract T update(T obj);

    public void saveAll(LinkedList<T> objs) {
        for (T obj : objs) {
            update(obj);
        }
    }

    public abstract T findById(int cle);

    public abstract T findByName(String nom);

    public abstract LinkedList<T> findAll();

    protected abstract ResultSet genericFindById(int cle);

    protected abstract ResultSet genericFindAll();

    protected abstract T ConvertRowToObj(ResultSet rs);
}
